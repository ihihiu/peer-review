package springproject.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;
import springproject.review.domain.Department;
import springproject.review.domain.Member;
import springproject.review.Repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional
    public String join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findById(member.getId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //id 조회
    public Member findOne(String memberId) {
        return memberRepository.findOne(memberId);
    }

    public List<Member> findById(String memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> findSurveyMembers(Department dept) {
        return memberRepository.findMembersByDeptExceptLeader(dept);
    }

}
