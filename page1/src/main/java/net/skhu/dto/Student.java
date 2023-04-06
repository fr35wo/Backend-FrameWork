package net.skhu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
//validation 은 입력된 폼 데이터를 자동으로 검증해주는 기능
@Data
public class Student {
    int id;

    @NotEmpty
    @NotBlank
    @Size(min=8, max=9)
    String studentNo;

    @NotEmpty
    @NotBlank
    String name;

    int departmentId;
    String sex;
    String phone;

    @Email
    String email;

    String departmentName;
}

