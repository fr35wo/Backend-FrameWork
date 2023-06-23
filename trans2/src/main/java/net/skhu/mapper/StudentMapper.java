package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

    @Select("""
            SELECT s.*, d.name departmentName
            FROM student s JOIN department d ON s.departmentId = d.id
            """)
    List<Student> findAll();

    @Delete("DELETE FROM student WHERE studentId = #{id}")
    void deleteById(int id);

}
