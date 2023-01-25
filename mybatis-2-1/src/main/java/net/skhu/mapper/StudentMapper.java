package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findOne(int id);

    @Select("""
        SELECT s.*, d.name departmentName
        FROM student s LEFT JOIN department d ON s.departmentId = d.id """)
    List<Student> findAll();


//    student 테이블에 새 레코드를 insert 할 때, auto increment 필드인 id 필드 값은, 자동으로 부여된다.
//    그래서 insert SQL 문에 id 필드값은 지정하지 않았다.
    @Insert("""
        INSERT student (studentNo, name, departmentId, phone, sex, email)
        VALUES (#{studentNo}, #{name}, #{departmentId}, #{phone}, #{sex}, #{email}) """)

//    INSERT할 테이블의 기본키(primary key) 필드 이름이 "id" 이고,
//    이 필드의 값은 새 레코드가 INSERT될 때, DB에서 자동으로 생성된다는 선언이다. (Auto Increment 필드)
//
//    새 INSERT가 완료되면 그렇게 자동으로 생성된 id 필드 값이, student 객체의 id 속성에 채워져 있다.
//    그래서 방금 INSERT된 레코드의 id 필드값을 알 수 있게 된다.
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Student student);

    @Update("""
        UPDATE student SET
          studentNo= #{studentNo},
          name = #{name},
          departmentId = #{departmentId},
          phone = #{phone},
          sex = #{sex},
          email = #{email}
        WHERE id = #{id} """)
    void update(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void delete(int id);
}
