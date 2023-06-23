package net.skhu.dto;

import lombok.Data;

@Data
public class User {
    int id;
    String loginName;
    String password;
    String name;
    String email;
    boolean enabled;
    String userType;
    Integer departmentId;
}
