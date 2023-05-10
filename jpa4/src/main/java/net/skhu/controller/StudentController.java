package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Student;
import net.skhu.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired StudentRepository studentRepository;

    @RequestMapping("student/test1")
    public Student test1() {
        return studentRepository.findByStudentNo("201732008");
    }

    @RequestMapping("student/test2")
    public List<Student> test2() {
        return studentRepository.findByName("김영수");
    }

    @RequestMapping("student/test3")
    public List<Student> test3() {
        return studentRepository.findByNameStartsWith("김");
    }

    @RequestMapping("student/test4")
    public List<Student> test4() {
        return studentRepository.findByDepartmentName("소프트웨어공학과");
    }

    @RequestMapping("student/test5")
    public List<Student> test5() {
        return studentRepository.findByDepartmentNameStartsWith("소프");
    }

    @RequestMapping("student/test6")
    public List<Student> test6() {
        return studentRepository.findByOrderByName();
    }

    @RequestMapping("student/test7")
    public List<Student> test7() {
        return studentRepository.findByOrderByNameDesc();
    }

    @RequestMapping("student/test8")
    public List<Student> test8() {
        return studentRepository.findByDepartmentIdOrderByNameDesc(1);
    }

}
