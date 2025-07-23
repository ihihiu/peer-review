package springproject.review.domain.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springproject.review.Repository.MemberRepository;
import springproject.review.domain.Member;
import springproject.review.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String creatForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/members/createMemberForm";
        }

        Member member = new Member();
        member.setId(form.getId());
        member.setPwd(form.getPwd());
        member.setDept(form.getDept());
        member.setName(form.getName());
        member.setRank(form.getRank());

        List<Member> findMembers = memberService.findById(member.getId());

        if (!findMembers.isEmpty()) {
            bindingResult.addError(new FieldError("Member", "id", "이미 존재하는 회원입니다"));
            return "/members/createMemberForm";
        }


        memberService.join(member);
        return "redirect:/";
    }

/*
    @GetMapping("/members/login")
    public String doLogin(Model model) {
        model.addAttribute("memberLoginForm", new MemberLoginForm());
        return "members/loginForm";
    }
*/
}
