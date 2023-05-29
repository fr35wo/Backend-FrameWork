package net.skhu.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Person;

@Controller
@RequestMapping("second")
public class SecondController {

    @RequestMapping("test1")
    public String test1(Model model, String name, double weight, String birthday) {
        model.addAttribute("name", name);
        model.addAttribute("weight", weight);
        model.addAttribute("birthday", birthday);
        return "second/test1";
    }

    @RequestMapping("test2")
    public String test2(Model model, String name, double weight,
            @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday) {
        model.addAttribute("name", name);
        model.addAttribute("weight", weight);
        model.addAttribute("birthday", birthday);
        return "second/test1";
    }

    @RequestMapping("test3")
    public String test3(Model model, Person person) {
        model.addAttribute("name", person.getName());
        model.addAttribute("weight", person.getWeight());
        model.addAttribute("birthday", person.getBirthday());
        return "second/test3";
    }

    @RequestMapping("test4")
    public String test4(Model model, Person person) {
        model.addAttribute("person", person);
        return "second/test4";
    }

    @RequestMapping("test5")
    public String test5(Model model, Person p) {
        return "second/test4";
    }
}
