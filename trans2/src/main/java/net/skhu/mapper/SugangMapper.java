package net.skhu.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SugangMapper {

    @Delete("DELETE FROM sugang WHERE studentId = #{studentId};")
    void deleteByStudentId(int studentId);

}

