package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Student;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        studentMapper.deleteById(id);
        return "redirect:list";
    }
}
