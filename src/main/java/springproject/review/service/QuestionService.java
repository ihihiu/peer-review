package springproject.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.review.Repository.QuestionRepository;
import springproject.review.domain.Questions;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Questions> findQuestions() {
        return questionRepository.findAll();
    }


}
