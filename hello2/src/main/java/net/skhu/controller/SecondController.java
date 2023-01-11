package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Product;

@Controller
@RequestMapping("second")
public class SecondController {

    @RequestMapping("test1")
    public String test1(Model model) {
        model.addAttribute("message", "안녕하세요");
        return "second/test1";
    }

    @RequestMapping("test2")
    public String test2(Model model) {
        Product product = new Product("맥주", 2000);
        model.addAttribute("product", product);
        return "second/test2";
    }

}
