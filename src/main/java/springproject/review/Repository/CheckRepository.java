package springproject.review.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springproject.review.domain.Member;
import springproject.review.domain.MemberCheck;
import springproject.review.domain.Status;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CheckRepository {

    private final EntityManager em;

    public void save(MemberCheck memberCheck) {
        em.persist(memberCheck);
    }


    public List<MemberCheck> findSurveyList(String loginId, Long surveyId) {
        return em.createQuery("select c from MemberCheck c where c.login_id=:loginId and c.survey_id= :surveyId", MemberCheck.class)
                .setParameter("loginId", loginId)
                .setParameter("surveyId", surveyId)
                .getResultList();
    }

    public MemberCheck findOne(Long id) {
        return em.find(MemberCheck.class, id);
    }

/*    public void changeStatus(Long id) {
        em.createQuery("update MemberCheck c set c.status = '평가완료' where c.id=:id")
                .setParameter("id", id);
    }*/

    public List<Long> findResultList(String loginId) {
        return em.createQuery("select distinct c.survey_id from MemberCheck c where c.login_id=:loginId")
                .setParameter("loginId", loginId)
                .getResultList();
    }

    public List<Long> findCheckId(Long surveyId, String loginId) {
        return em.createQuery("select c from MemberCheck c where c.survey_id=:surveyId and c.login_id=:loginId")
                .setParameter("surveyId", surveyId)
                .setParameter("loginId", loginId)
                .getResultList();
    }


    public boolean checkFinish(Long surveyId){
        int finish = em.createQuery("select distinct c.status from MemberCheck c where c.survey_id=:surveyId")
                .setParameter("surveyId", surveyId)
                .getResultList().size();
        if(finish==1){return true;}
        return false;

    }



}
