package springproject.review.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springproject.review.domain.*;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SurveyRepository {

    private final EntityManager em;

    public void save(Survey survey) {
        em.persist(survey);
    }

    public Survey findOne(int year, Quarter quarter, Department dept) {
        return em.createQuery("select s from Survey s where s.dept= :dept and s.year=:year and s.quarter= :quarter", Survey.class)
                .getSingleResult();
    }


    //여기 고쳤음
    public Survey findById(Long id) {
        return em.createQuery("select s from Survey s where s.id=:id", Survey.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Survey> validateDuplicationSurvey(Department dept, Quarter quarter, int year) {
        return em.createQuery("select s from Survey s where s.dept=:dept and s.quarter=:quarter and s.year=:year", Survey.class)
                .setParameter("dept", dept)
                .setParameter("quarter", quarter)
                .setParameter("year", year)
                .getResultList();
    }

    public List<Survey> findByDqy(Department dept, Quarter quarter, int year) {
        return em.createQuery("select s from Survey s where s.dept=:dept and s.quarter=:quarter and s.year=:year", Survey.class)
                .setParameter("dept", dept)
                .setParameter("quarter", quarter)
                .setParameter("year", year)
                .getResultList();
    }

    public List<Survey> findByDept(Department dept) {
        return em.createQuery("select s from Survey s where s.dept=:dept")
                .setParameter("dept", dept)
                .getResultList();
    }




}
