package springproject.review.domain;

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
public class ResultSum {


    @Id
    @GeneratedValue
    @Column(name = "sum_id")
    private Long id;

    private Long surveyId;

    private String subjectId;


    private int a1;
    private int a2;
    private int a3;
    private int a4;
    private int a5;
    private String a6;

    @ColumnDefault("0")
    private double count;

    public void initialSave(int a1, int a2, int a3, int a4, int a5, String a6) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.count++;
    }

    public void update(int a1, int a2, int a3, int a4, int a5, String a6) {
        this.a1 += a1;
        this.a2 += a2;
        this.a3 += a3;
        this.a4 += a4;
        this.a5 += a5;
        this.a6 += '\n' + a6;
        this.count++;
    }


}
