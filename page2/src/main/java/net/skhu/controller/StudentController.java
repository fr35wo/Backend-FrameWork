package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.Pagination;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired DepartmentMapper departmentMapper;
    @Autowired StudentMapper studentMapper;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("students", studentMapper.findByDepartmentId(pagination));
        pagination.setRecordCount(studentMapper.getCount(pagination));
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentMapper.findAll());
            return "student/edit";
        }
        studentMapper.insert(student);
        pagination.setDi(0);
        double temp = (double)studentMapper.getCount(pagination) / pagination.getSz();
        int lastPage = (int)Math.ceil(temp);
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        model.addAttribute("student", studentMapper.findOne(id));
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentMapper.findAll());
            return "student/edit";
        }
        studentMapper.update(student);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        studentMapper.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}
