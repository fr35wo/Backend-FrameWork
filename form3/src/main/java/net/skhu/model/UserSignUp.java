package net.skhu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserSignUp {

    @NotEmpty(message="로그인 네임을 입력하세요")
    @NotBlank(message="로그인 네임을 입력하세요")
    @Size(min=3, max=12, message="로그인 네임은 {min} 자리 이상 {max} 자리 이하이어야 합니다")
    String loginName;

    @NotEmpty(message="비밀번호를 입력하세요")
    @Size(min=6, max=12, message="비밀번호는 {min} 자리 이상 {max} 자리 이하이어야 합니다.")
    String passwd1;

    @NotEmpty(message="비밀번호를 한번 더 입력하세요")
    String passwd2;

    @NotEmpty(message="이름을 입력하세요")
    @Size(min=2, max=30, message="이름은 {min} 자리 이상 {max} 자리 이하이어야 합니다")
    String name;

    @NotEmpty(message="이메일 주소를 입력하세요")
    @Email(message="이메일 주소가 올바르지 않습니다")
    String email;

    int departmentId;
}
