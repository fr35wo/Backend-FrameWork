package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Student;
import net.skhu.model.Pagination;

@Mapper
public interface StudentMapper {

    @Select("""
        SELECT s.*, d.name departmentName
        FROM student s LEFT JOIN department d ON s.departmentId = d.id
        ORDER BY s.id
        LIMIT #{firstRecordIndex}, #{sz} """)
    List<Student> findAll(Pagination pagination);

    @Select("SELECT COUNT(id) FROM student")
    int getCount();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findOne(int id);

    @Insert("""
        INSERT student (studentNo, name, departmentId, sex, phone, email)
        VALUES (#{studentNo}, #{name}, #{departmentId}, #{sex}, #{phone}, #{email}) """)
    void insert(Student student);

    @Update("""
        UPDATE student SET
          studentNo = #{studentNo},
          name = #{name},
          departmentId = #{departmentId},
          sex = #{sex},
          phone = #{phone},
          email = #{email}
        WHERE id = #{id} """)
    void update(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void deleteById(int id);
}
