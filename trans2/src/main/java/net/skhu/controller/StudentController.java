package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Student;
import net.skhu.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired StudentService studentService;

    @GetMapping("list")
    public String list(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    @PostMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        studentService.deleteById(id);
        return "redirect:list";
    }
}

