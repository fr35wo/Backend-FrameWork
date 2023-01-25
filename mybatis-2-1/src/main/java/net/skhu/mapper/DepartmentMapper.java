package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Department;

@Mapper
@CacheNamespace(flushInterval=10000)
//DepartmentMapper에 캐시 기능을 활성화 한다.
//이 캐시는 10,000 밀리초(10초) 간격으로 자동으로 비워진다.

public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<Department> findAll();
}
