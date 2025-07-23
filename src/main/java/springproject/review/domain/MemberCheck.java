package springproject.review.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MemberCheck {

    @Id @GeneratedValue
    @Column(name = "check_id")
    private Long id;

    private Long survey_id;

    @Enumerated(EnumType.STRING)
    private Department dept;

    private String login_id;

    private String subject_id;

    private String subject_name;

    @Enumerated(EnumType.STRING)
    private Status status;


   /* @OneToOne(mappedBy = "memberCheck", fetch = FetchType.LAZY)
    private Result result;
*/



}
