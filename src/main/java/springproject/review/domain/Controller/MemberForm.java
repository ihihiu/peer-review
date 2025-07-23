package springproject.review.domain.Controller;

import lombok.Getter;
import lombok.Setter;
import springproject.review.domain.Department;
import springproject.review.domain.Rank;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Getter
@Setter
public class MemberForm {

    @NotBlank(message = "아이디를 입력해주세요.")
    //@Email(message = "올바른 이메일 주소를 입력해주세요.")  //수정
    public String id;

    @NotBlank(message = "이름을 입력해주세요.")
    @Pattern(regexp = "(?=\\S+$).{2,10}",message="이름은 공백을 제외하고 2글자 이상 입력해주세요.")
    public String name;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    public String pwd;

    public Department dept;    //개발_1팀, 개발_2팀, 개발_3팀
    public Rank rank; //팀장, 팀원

}