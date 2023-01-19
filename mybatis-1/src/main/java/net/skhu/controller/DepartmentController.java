package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Department;
import net.skhu.mapper.DepartmentMapper;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired DepartmentMapper departmentMapper;
//    DepartmentMapper 인터페이스를 구현한 Java 클래스를, spring mybatis가 자동으로 구현해 주고,
//    그 클래스의 객체를 한 개 생성하여, departmentMapper 멤버 변수에 자동으로 대입(autowired)해 준다.
//
//    그래서 departmentMapper 멤버 변수를 선언했을 뿐이고, 어떤 객체도 대입해 주지 않았지만,
//    mybatis spring이 자동으로 생성해준 객체가 이 멤버 변수에 자동으로 대입되어 있기 때문에,
//    액션 메소드에서 이 객체를 사용할 수 있다.


    @RequestMapping("list")
    public String list(Model model) {
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("departments", departments);
        return "department/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("department", new Department());
        return "department/edit";
    }

    @PostMapping("create")
    public String create(Model model, Department department) {
        departmentMapper.insert(department);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, int id) {
        Department department = departmentMapper.findOne(id);
        model.addAttribute("department", department);
        return "department/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Department department) {
        departmentMapper.update(department);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, int id) {
        departmentMapper.delete(id);
        return "redirect:list";
    }
}
