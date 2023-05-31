package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Student;
import net.skhu.model.Pagination;

public interface StudentRepository  extends JpaRepository<Student, Integer> {

    public default List<Student> findAll(Pagination pagination) {
        Page<Student> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
//departmentid로 조회한 다음 페이지 단위로 보여주기
    Page<Student> findByDepartmentId(int departmentId, Pageable pageable);


//    public default List<Student> findByDepartmentId(Pagination pagination) {
//        if (pagination.getDi() == 0) return findAll(pagination);
//        Page<Student> page = this.findByDepartmentId(pagination.getDi(),
//                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
//        pagination.setRecordCount((int)page.getTotalElements());
//        return page.getContent();
//    }

    Page<Student> findByDepartmentNameStartsWith(String departmentName, Pageable pageable);

    public default List<Student> findByDepartmentName(Pagination pagination) {
        if (pagination.getDn().length()==0) return findAll(pagination);
        Page<Student> page = this.findByDepartmentNameStartsWith(pagination.getDn(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int) page.getTotalElements());
        return page.getContent();
    }

}
