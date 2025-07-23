package springproject.review.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import springproject.review.domain.Department;
import springproject.review.domain.Member;
import springproject.review.domain.Rank;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(String id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findById(String id) {
        return em.createQuery("select m from Member m where m.id= :id", Member.class)
                .setParameter("id", id)
                .getResultList();
    }

    //아직 쓸모 없음
    public List<Member> findMembersByDeptExceptLeader(Department dept) {
        return em.createQuery("select m from Member m where m.dept= :dept and m.rank= '팀원'", Member.class)
                .setParameter("dept", dept)
                .getResultList();
    }

    /*public List<Member> findMembersByDept(Department dept) {
        return em.createQuery("select m from Member m where m.dept= :dept", Member.class)
                .setParameter("dept", dept)
                .getResultList();
    }
*/
    public List<Member> surveyMember(@SessionAttribute("loginMemberId") String id,
                                     @SessionAttribute("loginMemberDept") Department dept) {
        return em.createQuery("select m from Member m where m.dept=:dept and m.rank='팀원' and m.id NOT IN(:id)", Member.class)
                .getResultList();
    }







/*    //테스트 용 데이터
    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setId("HongGilDong");
        member.setPwd("1234");
        member.setName("홍길동");
        member.setDept(Department.1팀);
        member.setRank(Rank.팀장);

        save(member);
    }*/
}
