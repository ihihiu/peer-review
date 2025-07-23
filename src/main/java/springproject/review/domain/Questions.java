package springproject.review.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Questions {

    @Id @GeneratedValue
    @Column(name = "questions_id")
    private Long id;

    private String category;

    private String question;

    /*public Questions(String type, String question) {
        this.type = type;
        this.question = question;
    }*/
}


