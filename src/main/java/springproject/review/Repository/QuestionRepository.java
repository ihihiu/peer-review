package springproject.review.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springproject.review.domain.Questions;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {

    private final EntityManager em;

    public void save(Questions questions) {
        em.persist(questions);
    }

    //id 순서대로 가져옴
    public List<Questions> findAll() {
        return em.createQuery("select q from Questions q order by q.id", Questions.class).getResultList();
    }



}
