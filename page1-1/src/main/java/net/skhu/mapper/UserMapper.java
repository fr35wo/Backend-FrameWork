package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.User;
import net.skhu.model.Pagination;

@Mapper
public interface UserMapper {
	@Select("""
			SELECT s.*, d.name departmentName
			FROM user s LEFT JOIN department d ON s.departmentId = d.id
			ORDER BY s.id
			LIMIT #{firstRecordIndex}, #{sz} """)
	List<User> findAll(Pagination pagination);

	@Select("""
			SELECT s.*, d.name departmentName
			FROM user s LEFT JOIN department d ON s.departmentId = d.id
			WHERE #{di} = 0 OR s.departmentId = #{di}
			ORDER BY
			 (CASE WHEN #{od} = 0 THEN s.id END) ASC,
			 (CASE WHEN #{od} = 1 THEN s.loginName END) ASC,
			 (CASE WHEN #{od} = 2 THEN s.name END) ASC,
			 (CASE WHEN #{od} = 3 THEN d.name END) ASC
			LIMIT #{firstRecordIndex}, #{sz} """)
	List<User> findByDepartmentId(Pagination pagination);

	@Select("SELECT COUNT(id) FROM user WHERE #{di} = 0 OR departmentId = #{di}")
	int getCount(Pagination pagination);

	@Select("SELECT * FROM user WHERE id = #{id}")
	User findOne(int id);

	@Insert("""
			INSERT user (loginName, password, name, departmentId, enabled, userType, email)
			VALUES (#{loginName}, #{password}, #{name}, #{departmentId}, #{enabled}, #{userType}, #{email}) """)
	void insert(User user);

	@Update("""
			UPDATE user SET
			  loginName = #{loginName},
			  password = #{password},
			  name = #{name},
			  departmentId = #{departmentId},
			  enabled = #{enabled},
			  userType = #{userType},
			  email = #{email}
			WHERE id = #{id} """)
	void update(User user);

	@Delete("DELETE FROM user WHERE id = #{id}")
	void deleteById(int id);

}
