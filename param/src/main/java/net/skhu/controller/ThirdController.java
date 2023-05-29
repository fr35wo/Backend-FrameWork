package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Person;

@Controller
@RequestMapping("third")
public class ThirdController {

    @RequestMapping(value="test1", method=RequestMethod.GET)
    public String test1(Model model) {
        model.addAttribute("person", new Person());
        return "third/test1";
    }

    @RequestMapping(value="test1", method=RequestMethod.POST)
    public String test1(Model model, Person person) {
        // TODO: 저장하는 코드를 구현해야 함.
        model.addAttribute("message", "저장되었습니다");
        return "third/test1";
    }

    @GetMapping("test2")
    public String test2(Model model) {
        model.addAttribute("person", new Person());
        return "third/test1";
    }

    @PostMapping("test2")
    public String test2(Model model, Person person) {
        // TODO: 저장하는 코드를 구현해야 함.
        model.addAttribute("message", "저장되었습니다");
        return "third/test1";
    }
}
