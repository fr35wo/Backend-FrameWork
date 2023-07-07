package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Bus;

@Mapper
public interface BusMapper {

    @Select("SELECT * FROM bus WHERE id = #{id}")
    Bus findOne(int id);

    @Select("""
        SELECT b.*, c.categoryName categoryName
        FROM bus b LEFT JOIN category c ON b.categoryId = c.id """)
    List<Bus> findAll();

    @Insert("""
        INSERT bus (busNo, firstStop, lastStop, categoryId, firstBus, lastBus)
        VALUES (#{busNo}, #{firstStop}, #{lastStop}, #{categoryId}, #{firstBus}, #{lastBus}) """)
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Bus bus);

    @Update("""
        UPDATE bus SET
          busNo= #{busNo},
          firstStop = #{firstStop},
          lastStop = #{lastStop},
          categoryId = #{categoryId},
          firstBus = #{firstBus},
          lastBus = #{lastBus}
        WHERE id = #{id} """)
    void update(Bus bus);

    @Delete("DELETE FROM bus WHERE id = #{id}")
    void delete(int id);
}

