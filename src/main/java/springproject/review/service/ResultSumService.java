package springproject.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.review.Repository.CheckRepository;
import springproject.review.Repository.ResultSumRepository;
import springproject.review.Repository.SurveyRepository;
import springproject.review.domain.ResultSum;
import springproject.review.domain.Survey;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ResultSumService {

    private final ResultSumRepository resultSumRepository;
    private final SurveyRepository surveyRepository;
    private final CheckRepository checkRepository;

    @Transactional
    public void save(ResultSum resultSum) {
        resultSumRepository.save(resultSum);
    }


    public ResultSum findOne(Long surveyId, String subjectId) {
        return resultSumRepository.findOne(surveyId, subjectId);
    }

    public List<Survey> ResultList(String loginId) {
        List<Long> surveyIdList = checkRepository.findResultList(loginId);

        List<Survey> surveyList = new ArrayList<Survey>();
        for (Long id : surveyIdList) {
            Survey survey = surveyRepository.findById(id);
            surveyList.add(survey);
        }

        return surveyList;
    }

    public List<Double> getAverage(Long surveyId, String subjectId) {
        List<Double> average = new ArrayList<>();
        ResultSum result = resultSumRepository.findOne(surveyId, subjectId);
        double count = result.getCount();

        average.add(0, Math.round((double)result.getA1()/count*100)/100.0);
        average.add(1, Math.round((double)result.getA2()/count*100)/100.0);
        average.add(2, Math.round((double)result.getA3()/count*100)/100.0);
        average.add(3, Math.round((double)result.getA4()/count*100)/100.0);
        average.add(4, Math.round((double)result.getA5()/count*100)/100.0);
        double sum = result.getA1()+ result.getA2()+result.getA3()+ result.getA4()+ result.getA5();
        average.add(5, (double) Math.round(sum/count/5*100)/100.0);
        return average;
    }

    public String getOpinion(Long surveyId, String subjectId) {
        return resultSumRepository.findOpinion(surveyId, subjectId);
    }

    public List<ResultSum> getResults(Long surveyId) {
        return resultSumRepository.getResults(surveyId);
    }

}