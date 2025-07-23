package springproject.review.domain.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import springproject.review.domain.*;
import springproject.review.service.MemberService;
import springproject.review.service.ResultSumService;
import springproject.review.service.SurveyService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LeaderController {

    private final SurveyService surveyService;
    private final ResultSumService resultSumService;
    private final MemberService memberService;

    @GetMapping("/teamResultList")
    public String resultList(@SessionAttribute(name = "loginMember", required = false) Member loginMember,
                             Model model) {

        List<Survey> resultList = surveyService.findByDept(loginMember.getDept());

        model.addAttribute("resultList", resultList);

        return "leader/surveyList";
    }


    @GetMapping("/teamResult/{surveyId}")
    public String result(@PathVariable("surveyId") Long surveyId,
                         @SessionAttribute(name = "loginMember", required = false) Member loginMember,
                         Model model) {

        Survey survey = surveyService.findById(surveyId);
        model.addAttribute("survey", survey);

        List<ResultSum> results = resultSumService.getResults(surveyId);
        model.addAttribute("results", results);


        return "leader/result";
    }
}
