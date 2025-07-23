package springproject.review.domain.Controller;

import lombok.Getter;
import lombok.Setter;
import springproject.review.domain.Department;
import springproject.review.domain.Quarter;

@Getter
@Setter
public class SurveyForm {

    public Department dept;
//    public Year year;
    public int year;
    public Quarter quarter;

}
