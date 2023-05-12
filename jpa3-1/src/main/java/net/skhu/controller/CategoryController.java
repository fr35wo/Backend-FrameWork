package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.repository.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired CategoryRepository categoryRepository;

    @RequestMapping("category/list1")
    public String list1(Model model) {
        model.addAttribute("categorys", categoryRepository.findAll());
        return "category/list1";
    }

    @RequestMapping("category/list2")
    public String list2(Model model) {
        model.addAttribute("categorys", categoryRepository.findAll());
        return "category/list2";
    }

}
