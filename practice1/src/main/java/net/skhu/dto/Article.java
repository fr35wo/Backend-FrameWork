package net.skhu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Article {
	int id;

    @NotEmpty
    @NotBlank
    @Size(min=8, max=9)
    String no;

    @NotEmpty
    @NotBlank
    String title;

    int boardId;
    String userId;
    String writetime;

    @Email
    String body;

    String departmentName;

}
