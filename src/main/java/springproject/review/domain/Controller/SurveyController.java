package springproject.review.domain.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springproject.review.domain.*;
import springproject.review.service.MemberService;
import springproject.review.service.SurveyService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j

public class SurveyController {

    private final SurveyService surveyService;
    private final MemberService memberService;

    @GetMapping("/survey")
    public String createForm(Model model,
                             @SessionAttribute(name = "loginMember", required = false) Member loginMember) {

/*
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("loginMember");
        System.out.println("member.getId() = " + member.getId());*/


        model.addAttribute("member", loginMember);
        model.addAttribute("surveyForm", new SurveyForm());
        return "survey/createSurvey";
    }

    @PostMapping("/survey")
    public void create(Model model, @Valid SurveyForm form, BindingResult result, HttpServletResponse response) throws IllegalStateException, IOException {
        /*if (result.hasErrors()) {
            return "survey/createSurvey";
        }*/

        Survey survey = new Survey();
        survey.setDept(form.getDept());
        survey.setYear(form.getYear());
        survey.setQuarter(form.getQuarter());

        List<Survey> findSurveyList = surveyService.findByDqy(survey.getDept(), survey.getQuarter(), survey.getYear());

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(!findSurveyList.isEmpty()) {
            out.println("<script>alert('이미 존재하는 평가지입니다.');location.href='/survey'; </script>");
            /*out.flush();
            response.sendRedirect("/survey");*/
        }else {
            surveyService.saveSurvey(survey);
            response.sendRedirect("/members/leader");
            //return "redirect:/members/leader";
        }



    }



}