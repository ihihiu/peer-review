package springproject.review.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springproject.review.domain.ResultSum;

import javax.persistence.EntityManager;
import javax.xml.transform.Result;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResultSumRepository {

    private final EntityManager em;
    private final CheckRepository checkRepository;

    public void save(ResultSum resultSum) {
        em.persist(resultSum);
    }


    public ResultSum findOne(Long surveyId, String subjectId) {
        return em.createQuery("select r from ResultSum r where r.surveyId=:surveyId and r.subjectId=:subjectId", ResultSum.class)
                .setParameter("surveyId", surveyId)
                .setParameter("subjectId", subjectId)
                .getResultList().stream().findFirst().orElse(null);

    }

    public String findOpinion(Long surveyId, String loginId) {
        return em.createQuery("select r.a6 from ResultSum r where r.surveyId=:surveyId and r.subjectId=:loginId")
                .setParameter("surveyId", surveyId)
                .setParameter("loginId", loginId)
                .getSingleResult().toString();

    }

    public List<ResultSum> getResults(Long surveyId) {
        return em.createQuery("select r from ResultSum r where r.surveyId=:surveyId", ResultSum.class)
                .setParameter("surveyId", surveyId)
                .getResultList();
    }


}


