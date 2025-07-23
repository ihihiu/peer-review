package springproject.review.domain.Controller;

import lombok.Getter;
import lombok.Setter;
import springproject.review.domain.Department;
import springproject.review.domain.Rank;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberLoginForm {

    @NotBlank(message = "아이디를 입력하세요.")
    public String id;

    @NotBlank(message = "비밀 번호를 입력하세요.")
    public String pwd;

}
