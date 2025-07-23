package springproject.review.domain.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springproject.review.domain.*;
import springproject.review.service.CheckService;
import springproject.review.service.LoginService;
import springproject.review.service.SurveyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SurveyService surveyService;
    private final CheckService checkService;

    @GetMapping("/members/login")
    public String LoginForm(Model model) {
        model.addAttribute("memberLoginForm", new MemberForm());  //수정
        return "members/loginForm";

    }

    @PostMapping("/members/login")
    public String Login(@ModelAttribute @Validated MemberLoginForm form,
                        BindingResult bindingResult,
                        //@RequestParam("id") String id,
                        @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
                        HttpServletRequest request,
                        Model model) throws Exception {

        loginMember = loginService.login(form.id, form.pwd);
/*

        if (loginMember == null) {
            bindingResult.addError(new FieldError("Member", "id", "존재하지 않는 회원입니다."));
            return "members/loginForm";
        }
*/

        if (loginMember==null) {
            bindingResult.addError(new FieldError("Member","id", "존재하지 않는 회원입니다."));
            return "members/loginForm";
        } else if (!form.pwd.equals(loginMember.getPwd())){
            bindingResult.addError(new FieldError("Member", "pwd", "비밀번호가 틀렸습니다."));
            return "members/loginForm";
        }


        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        model.addAttribute("member", loginMember);

        if (loginMember.getRank() == Rank.팀원) {
            return "members/member";
        } else {
            return "members/leader";
        }


    }

    @PostMapping("/logout")
    public String Logout(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
/*

        System.out.println("session.getAttribute(\"loginMember\") = " + session.getAttribute("loginMember"));
        System.out.println("session.getAttribute(\"loginMemberDept\") = " + session.getAttribute("loginMemberDept"));
*/
        System.out.println("session = " + session);


        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        System.out.println("session = " + session);


        return "redirect:/";
    }

    @GetMapping("/members/leader")
    public String leader(@SessionAttribute(name = "loginMember", required = false) Member loginMember, Model model) {

        model.addAttribute("member", loginMember);
        System.out.println("loginMember.getId() = " + loginMember.getId());
        System.out.println("loginMember.getRank() = " + loginMember.getRank());

        return "/members/leader";
    }

    @GetMapping("/members/member")
    public String member(@SessionAttribute(name = "loginMember", required = false) Member loginMember, Model model) {

        model.addAttribute("member", loginMember);
        System.out.println("loginMember.getId() = " + loginMember.getId());
        System.out.println("loginMember.getRank() = " + loginMember.getRank());

        return "/members/member";
    }
}
