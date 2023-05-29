package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("first")
public class FirstController {

	@RequestMapping("test1")
	public String test1(Model model, @RequestParam("id") int id, @RequestParam("name") String name) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "first/test1";
	}

	@RequestMapping("test2")
	public String test2(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") int id,
			@RequestParam(value = "name", required = false, defaultValue = "nobody") String name) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "first/test1";
	}

	@RequestMapping("test3")
	public String test3(Model model, int id, String name) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "first/test1";
	}

	@RequestMapping("test4")
	public String test4(Model model, Integer id, String name) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "first/test1";
	}
}
