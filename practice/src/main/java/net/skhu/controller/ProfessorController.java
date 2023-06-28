package net.skhu.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Department;
import net.skhu.dto.Professor;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.ProfessorMapper;

@Controller
@RequestMapping("professor")
public class ProfessorController {

    @Autowired ProfessorMapper professorMapper;
    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<Professor> professors = professorMapper.findAll();
        model.addAttribute("professors", professors);
        return "professor/list";
    }

    @GetMapping("create")
    public String create(Model model) {
    	Professor professor = new Professor();
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("professor", professor);
        model.addAttribute("departments", departments);
        return "professor/edit";
    }

    @PostMapping("create")
    public String create(Model model, Professor professor) {
    	professorMapper.insert(professor);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, int id) {
    	Professor professor = professorMapper.findOne(id);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("professor", professor);
        model.addAttribute("departments", departments);
        return "professor/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Professor professor) {
    	professorMapper.update(professor);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, int id) {
    	professorMapper.delete(id);
        return "redirect:list";
    }
}
