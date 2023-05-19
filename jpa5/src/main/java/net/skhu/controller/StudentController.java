package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Student;
import net.skhu.repository.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired StudentRepository studentRepository;

    @RequestMapping("test1")
    public List<Object[]> test1() {
        return studentRepository.findSugangCount();
    }

    @RequestMapping("test2")
    public List<Student> test2() {
        return studentRepository.findByLectureTite("자료구조");
    }

    @RequestMapping("test3")
    public List<Student> test3() {
        return studentRepository.findByProfessorIdOrProfessorName(0, "이몽룡");
    }

    @RequestMapping("test4")
    public List<Student> test4() {
        return studentRepository.findByProfessorNameOrProfessorId(null, 13);
    }

}
