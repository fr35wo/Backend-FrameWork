package net.skhu.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Person;
import net.skhu.model.Pagination;

@Mapper
public interface PersonMapper {
	@Select("""
	        SELECT s.*, d.title categoryTitle
	        FROM person s LEFT JOIN category d ON s.categoryCode = d.code
	        ORDER BY s.pid
	        LIMIT #{firstRecordIndex}, #{sz} """)
	    List<Person> findAll(Pagination pagination);

	    @Select("SELECT COUNT(pid) FROM person")
	    int getCount();

	    @Select("SELECT * FROM person WHERE pid = #{pid}")
	    Person findOne(int pid);

	    @Insert("""
	        INSERT person (categoryCode, name, title, gender, phone, email)
	        VALUES (#{categoryCode}, #{name}, #{title}, #{gender}, #{phone}, #{email}) """)
	    void insert(Person person);
//departmetn id 대신 name이		categorycode == category title list에서
	    @Update("""
	        UPDATE person SET
	          categoryCode = #{categoryCode},
	          name = #{name},
	          title = #{title},
	          gender = #{gender},
	          phone = #{phone},
	          email = #{email}
	        WHERE pid = #{pid} """)
	    void update(Person person);

	    @Delete("DELETE FROM person WHERE pid = #{pid}")
	    void deleteById(int pid);

}
