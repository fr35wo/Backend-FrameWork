package net.skhu.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {
	int id;

    @NotEmpty
    @NotBlank
    @Size(min=3, max=9)
    String loginName;

    String password;

    @NotEmpty
    @NotBlank
    String name;

    @Email
    String email;

    String enabled;
    String userType;
    int departmentId;

    String departmentName;

}
