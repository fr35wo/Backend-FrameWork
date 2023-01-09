//컨트롤러 클래스는 웹브라우저의 URL 요청을 받아서, 웹서버에서 실행되는 자바 클래스이다.
//웹브라우저가 웹서버에 어떤 URL을 요청을 하면, 그 URL에 해당하는 컨트롤러의 메소드가 자동으로 호출되어 실행된다.

package net.skhu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 클래스에 이 어노테이션(annotation)을 붙여주어야 한다.
//이것을 붙여주지 않으면 컨트롤러 클래스가 실행되지 않는다. 404 Not Found 에러가 발생할 것이다.

@Controller
public class HomeController {

//	자동으로 호출할 액션 메소드를 찾을 때 컨트롤러 클래스 이름이나 액션 메소드의 이름은 상관 없고,
//	@RequestMapping 어노테이션에 등록된 URL만 일치하면 된다.
//	만약 요청된 URL과 일치하는 액션 메소드가 없다면, 404 Not Found 에러가 발생할 것이다.

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "좋은 아침");
		model.addAttribute("now", new Date());
		return "index";
	}
}
