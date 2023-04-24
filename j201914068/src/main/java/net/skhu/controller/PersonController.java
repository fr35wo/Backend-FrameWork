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
import net.skhu.dto.Person;
import net.skhu.mapper.CategoryMapper;
import net.skhu.mapper.PersonMapper;
import net.skhu.model.Pagination;

@Controller
@RequestMapping("person")
public class PersonController {
	@Autowired CategoryMapper categoryMapper;
    @Autowired PersonMapper personMapper;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("persons", personMapper.findAll(pagination));
        pagination.setRecordCount(personMapper.getCount());
        return "person/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("person", new Person());
        model.addAttribute("categorys", categoryMapper.findAll());
        return "person/edit";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categorys", categoryMapper.findAll());
            return "person/edit";
        }
        personMapper.insert(person);
        int lastPage = (int)Math.ceil((double)personMapper.getCount() / pagination.getSz());
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("pid") int pid, Pagination pagination) {
        model.addAttribute("person", personMapper.findOne(pid));
        model.addAttribute("categorys", categoryMapper.findAll());
        return "person/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Pagination pagination,
            @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categorys", categoryMapper.findAll());
            return "person/edit";
        }
        personMapper.update(person);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("pid") int pid, Pagination pagination) {
    	personMapper.deleteById(pid);
        return "redirect:list?" + pagination.getQueryString();
    }

}
