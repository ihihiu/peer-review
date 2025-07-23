package springproject.review.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Survey {

    @Id @GeneratedValue
    @Column(name = "survey_id")
    private Long id;

    //@Enumerated(EnumType.STRING)
    private int year;

    @Enumerated(EnumType.STRING)
    private Quarter quarter;

    @Enumerated(EnumType.STRING)
    private Department dept;

    private int count;

}
