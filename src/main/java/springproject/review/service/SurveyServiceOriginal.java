package springproject.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.review.Repository.CheckRepository;
import springproject.review.Repository.MemberRepository;
import springproject.review.Repository.SurveyRepository;
import springproject.review.domain.*;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyServiceOriginal {

    private final SurveyRepository surveyRepository;
    private final MemberRepository memberRepository;
    private final CheckRepository checkRepository;
    @Transactional
    public void saveSurvey(Survey survey) {
        surveyRepository.save(survey);

        List<Member> members = memberRepository.findMembersByDeptExceptLeader(survey.getDept());
        for (Member loginMember : members) {
            loginMember.setSurvey_id(survey.getId());
            for (Member subjectMember : members) {
                if (loginMember.getId() != subjectMember.getId()) {
                    MemberCheck memberCheck = new MemberCheck();
                    memberCheck.setSurvey_id(survey.getId());
                    memberCheck.setDept(loginMember.getDept());
                    memberCheck.setLogin_id(loginMember.getId());
                    memberCheck.setSubject_id(subjectMember.getId());
                    memberCheck.setSubject_name(subjectMember.getName());
                    memberCheck.setStatus(Status.평가하기);
                    checkRepository.save(memberCheck);
                }
            }
        }
    }


    public Long surveyId(String id) {
        return memberRepository.findOne(id).getSurvey_id();
    }

    public Survey surveyInfo(String id) {
        Long survey_id = memberRepository.findOne(id).getSurvey_id();
        return surveyRepository.findById(survey_id);
    }

    public Survey findById(Long id) {
        return surveyRepository.findById(id);
    }


    public List<Survey> validateDuplicationSurvey(Department dept, Quarter quarter, int year) {
        return surveyRepository.validateDuplicationSurvey(dept, quarter, year);
    }

    public List<Survey> findByDqy(Department surveyDept, Quarter surveyQuarter, int surveyYear) {
        return surveyRepository.findByDqy(surveyDept,surveyQuarter,surveyYear);
    }






}
