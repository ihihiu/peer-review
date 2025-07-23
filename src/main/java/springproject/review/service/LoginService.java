package springproject.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import springproject.review.Repository.MemberRepository;
import springproject.review.domain.Member;

import javax.servlet.http.HttpSession;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    //여기부터 수정!!!!!!!!!!!!!!!!

   /* public Member login(@RequestParam("id") String loginId,
                        @RequestParam("pwd") String loginPwd
                        *//*@SessionAttribute("loginMember") String loginMember,
                        @SessionAttribute("loginMemberDept")Department loginMemberDept,
                        HttpSession session*//*) {
        Member member = memberRepository.findOne(loginId);
        System.out.println("loginId = " + loginId);
        System.out.println("member.getPwd() = " + member.getPwd());
        System.out.println("loginPwd = " + loginPwd);


        if (member == null) {
            throw new IllegalStateException("존재하지 않는 회원입니다.\n 아이디를 다시 입력해주세요.");
        } else if (!loginPwd.equals(member.getPwd())) {
            throw new IllegalStateException("비밀번호 오류입니다.");
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMemberId", member.getId());
        session.setAttribute("loginMemberDept", member.getDept());
*//*
        session.setAttribute("loginMember", member.getId());
        session.setAttribute("loginMemberDept",member.getDept());*//*
        return member;
    }
*/


    public Member login(String id, String pwd) throws Exception
    {
        Member member = memberRepository.findOne(id);

       /* if (member == null) {
            throw new IllegalStateException("존재하지 않는 회원입니다.\n 아이디를 다시 입력해주세요.");
        } else if (!pwd.equals(member.getPwd())) {
            throw new IllegalStateException("비밀번호 오류입니다.");
        }*/

        return member;

    }
}
