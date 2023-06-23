package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE loginName = #{loginName}")
    User findByLoginName(String loginName);

    @Insert("""
        INSERT user (loginName, password, name, email, enabled, userType, departmentId)
        VALUES (#{loginName}, #{password}, #{name}, #{email}, #{enabled}, #{userType}, #{departmentId}) """)
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(User user);
}
