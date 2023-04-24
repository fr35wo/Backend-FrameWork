package net.skhu.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Person {
    int pid;

    @NotEmpty
    @NotBlank
    @Size(min=1, max=3)
    String categoryTitle;

    @NotEmpty
    @NotBlank
    String name;

    int categoryCode;


    @Email
    String email;

    String gender;
    String phone;

    int title;
//categorycode랑 code로 조인
}
