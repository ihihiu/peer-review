package springproject.review.domain.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springproject.review.domain.*;
import springproject.review.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes({"loginMemberId", "loginMemberDept"})
public class ReviewController {

    private final SurveyService surveyService;
    private final CheckService checkService;
    private final QuestionService questionService;
    private final ResultSumService resultSumService;

    @GetMapping("/surveyList")
    public String SurveyList(HttpServletRequest request,
                             @SessionAttribute(name = "loginMember", required = false) Member loginMember,
                             HttpServletResponse response,
                             Model model){

        model.addAttribute("member", loginMember);
        Long surveyId = surveyService.surveyId(loginMember.getId());


        List<MemberCheck> memberCheckList = checkService.findSurveyList(loginMember.getId(), surveyId);
        model.addAttribute("memberCheckList", memberCheckList);


        Survey survey = surveyService.findById(surveyId);
        model.addAttribute("survey", survey);

        //response.sendRedirect("/survey/surveyList");

        return "survey/surveyList";

    }


    @GetMapping("/survey/{id}/review")
    public String review(@PathVariable("id") Long id, Model model,
                         @SessionAttribute(name = "loginMember", required = false) Member loginMember) {

        //model.addAttribute("member", loginMember);
        MemberCheck check = checkService.findOne(id);
        model.addAttribute("check", check);
        List<Questions> questions = questionService.findQuestions();
        model.addAttribute("questions", questions);
        model.addAttribute("form", new AnswerForm());

        return "survey/review";
    }

    @PostMapping("/survey/{id}/review")
    public String reviewFinished(HttpServletRequest request, @PathVariable Long id, @ModelAttribute("form") AnswerForm form) {

        HttpSession session = request.getSession();
        String loginMemberId = (String) session.getAttribute("loginMemberId");
        System.out.println("loginMemberId = " + loginMemberId);

        MemberCheck check = checkService.findOne(id);

        ResultSum resultSum;
        if (resultSumService.findOne(check.getSurvey_id(), check.getSubject_id()) == null) {
            resultSum = new ResultSum();
            resultSum.setSurveyId(check.getSurvey_id());
            resultSum.setSubjectId(check.getSubject_id());
            resultSum.initialSave(Integer.parseInt(form.getA1()),Integer.parseInt(form.getA2()),Integer.parseInt(form.getA3()),
                    Integer.parseInt(form.getA4()),Integer.parseInt(form.getA5()), form.a6);
        }else{
            resultSum = resultSumService.findOne(check.getSurvey_id(), check.getSubject_id());
            resultSum.update(Integer.parseInt(form.getA1()),Integer.parseInt(form.getA2()),Integer.parseInt(form.getA3()),
                    Integer.parseInt(form.getA4()),Integer.parseInt(form.getA5()), form.a6);
        }

        resultSumService.save(resultSum);

        checkService.changeStatus(id);
        surveyService.reduceCount(check.getSurvey_id());

        return "redirect:/surveyList";
    }
}