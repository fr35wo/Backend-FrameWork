package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import net.skhu.entity.Student;

@Controller
public class JPQLController {

    @Autowired JpaContext jpaContext;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("execute")
    public @ResponseBody Object jpql(@RequestParam("jpql") String jpql) {
        EntityManager manager = jpaContext.getEntityManagerByManagedType(Student.class);
        Query query = manager.createQuery(jpql);
        Object r = query.getResultList();
        return r;
    }
}

//SELECT s.studentNo, s.name, d.name
//FROM student s LEFT JOIN department d
//ON s.departmentId = d.id

//single valued association 은 조인 할 필요 x
//왜냐하면 엔티티 클래스에 이미 department속성이 있기 때문
//ex)
//SELECT s.studentNo, s.name, s.department.name
//FROM Student s

//collection valued association은 조인 해야 한다.
//student -> sugang collection 조인 필요
//sugang -> lecture single
//ex)
//SELECT g.lecture.title
//FROM Student s JOIN s.sugangs g
//WHERE s.studentNo = '201532006'



