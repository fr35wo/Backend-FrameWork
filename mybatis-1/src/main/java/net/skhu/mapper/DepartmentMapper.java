package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Department;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<Department> findAll();

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department findOne(int id);
//    Department 객체를 한 개 생성해서, 조회 결과 레코드의 각 컬럼의 값을,
//    이 Department 객체에 채워서 리턴한다.
//    이때 컬럼명과 객체의 속성명이 일치하는 것만 채워지고, 일치하지 않는 것은 무시된다.


    @Insert("INSERT department (name, shortName, phone) VALUES (#{name}, #{shortName}, #{phone})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    //  INSERT할 테이블의 기본키(primary key) 필드 이름이 "id" 이고,
    //이 필드의 값은 자동으로 생성된다는 선언이다. (Auto Increment 필드)
    void insert(Department department);

    @Update("UPDATE department SET name = #{name}, shortName = #{shortName}, phone = #{phone} WHERE id = #{id}")
    void update(Department department);

    @Delete("DELETE FROM department WHERE id = #{id}")
    void delete(int id);
}
