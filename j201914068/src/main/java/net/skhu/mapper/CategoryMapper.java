package net.skhu.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Category;

@Mapper
public interface CategoryMapper {
	@Select("SELECT * FROM category")
    List<Category> findAll();

}
