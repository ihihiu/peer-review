package springproject.review.domain.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import springproject.review.domain.*;
import springproject.review.service.CheckService;
import springproject.review.service.QuestionService;
import springproject.review.service.ResultSumService;
import springproject.review.service.SurveyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ResultController {

    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final ResultSumService resultSumService;
    private final CheckService checkService;

    @GetMapping("/resultList")
    public String resultList(@SessionAttribute(name = "loginMember", required = false) Member loginMember,
                             Model model) {


        System.out.println("loginMember.getId() = " + loginMember.getId());
        List<Survey> resultList = resultSumService.ResultList(loginMember.getId());
        model.addAttribute("resultList", resultList);

        return "result/resultList";
    }


    @GetMapping("/result/{surveyId}")
    public String result(@PathVariable("surveyId") Long surveyId,
                         @SessionAttribute(name = "loginMember", required = false) Member loginMember,
                         Model model) {

        model.addAttribute("member", loginMember);

        Survey survey = surveyService.findById(surveyId);
        model.addAttribute("survey", survey);

        List<Questions> questions = questionService.findQuestions();
        model.addAttribute("questions", questions);

        List<Double> average = resultSumService.getAverage(surveyId, loginMember.getId());
        model.addAttribute("average", average);


        ResultSum resultSum = resultSumService.findOne(surveyId, loginMember.getId());
        model.addAttribute("resultSum", resultSum);

        String opinion = resultSumService.getOpinion(surveyId, loginMember.getId());
        model.addAttribute("opinion", opinion);

       /* Average average = resultService.resultAverage(surveyId, loginMember.getId());
        model.addAttribute("average", average);

        List<String> opinion = resultService.getOpinion(surveyId, loginMember.getId());
        model.addAttribute("opinion", opinion);
*/
        return "result/result";
    }



}
