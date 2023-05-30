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
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.Pagination;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired DepartmentMapper departmentMapper;
    @Autowired StudentMapper studentMapper;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("students", studentMapper.findAll(pagination));
        pagination.setRecordCount(studentMapper.getCount());
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
        try {
            if (bindingResult.hasErrors() == false) {
                studentMapper.insert(student);
                int lastPage = (int)Math.ceil((double)studentMapper.getCount() / pagination.getSz());
                pagination.setPg(lastPage);
                return "redirect:list?" + pagination.getQueryString();
            }
        } catch (Exception exception) {
            bindingResult.reject("error", "등록 실패");
            log.error("등록 실패 {}", student, exception);
        }
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
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
        try {
            if (bindingResult.hasErrors() == false) {
                studentMapper.update(student);
                return "redirect:list?" + pagination.getQueryString();
            }
        } catch (Exception exception) {
            bindingResult.reject("error", "저장 실패");
            log.error("저장 실패 {}", student, exception);
        }
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        try {
            studentMapper.deleteById(id);
            return "redirect:list?" + pagination.getQueryString();
        } catch (Exception exception) {
            bindingResult.reject("error", "삭제 실패");
            log.error("삭제 실패 {}", id, exception);
        }
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }
}
