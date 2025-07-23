package springproject.review.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DynamicInsert
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    private String name;

    private String pwd;

    @Enumerated(EnumType.STRING)
    private Department dept;    //개발_1팀, 개발_2팀, 개발_3팀

    @Enumerated(EnumType.STRING)
    private Rank rank; //팀장, 팀원

    @ColumnDefault("0")
    private Long survey_id;


}
