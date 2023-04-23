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
import net.skhu.dto.User;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.UserMapper;
import net.skhu.model.Pagination;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired DepartmentMapper departmentMapper;
    @Autowired UserMapper userMapper;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("users", userMapper.findByDepartmentId(pagination));
        pagination.setRecordCount(userMapper.getCount(pagination));
        model.addAttribute("departments", departmentMapper.findAll());
        return "user/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("user", new User());
        model.addAttribute("departments", departmentMapper.findAll());
        return "user/edit";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentMapper.findAll());
            return "user/edit";
        }
        userMapper.insert(user);
        pagination.setDi(0);
        int lastPage = (int)Math.ceil((double)userMapper.getCount(pagination) / pagination.getSz());
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        model.addAttribute("user", userMapper.findOne(id));
        model.addAttribute("departments", departmentMapper.findAll());
        return "user/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Pagination pagination,
            @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentMapper.findAll());
            return "user/edit";
        }
        userMapper.update(user);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
    	userMapper.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }

}
