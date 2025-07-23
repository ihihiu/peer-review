package springproject.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.review.Repository.CheckRepository;
import springproject.review.Repository.MemberRepository;
import springproject.review.domain.MemberCheck;
import springproject.review.domain.Status;
import springproject.review.domain.Survey;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckService {

    private final CheckRepository checkRepository;

    public List<MemberCheck> findSurveyList(String loginId,Long surveyId) {
        return checkRepository.findSurveyList(loginId, surveyId);
    }

    public MemberCheck findOne(Long checkId) {
        return checkRepository.findOne(checkId);
    }

/*    @Transactional
    public void changeStatus(Long id) {
        checkRepository.changeStatus(id);
    }*/


    @Transactional
    public void changeStatus(Long id) {
        MemberCheck memberCheck = checkRepository.findOne(id);
        memberCheck.setStatus(Status.평가완료);
    }

    public boolean checkFinish(Long surveyId) {
        return checkRepository.checkFinish(surveyId);
    }
}
