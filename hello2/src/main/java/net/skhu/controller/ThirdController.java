package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;

@Controller
@RequestMapping("third")
public class ThirdController {

	 @RequestMapping("test1")
	    public String test1(Model model) {
	        Student student = new Student(1,"201914068","홍석현","seokhyeon");
	        model.addAttribute("student", student);
	        return "third/test1";
	    }

}

//웹브라우저가 웹서버의 URL을 요청하는 것을 HTTP request이라고 한다.
//서버가 Spring Web MVC 앱인 경우, 이 요청에 의해서 컨트롤러의 액션 메소드가 자동으로 호출된다.
//
//이 요청(HTTP Request)에 담겨서 서버에 전달되는 파라미터를, request parameter이라고 한다.
//request parameter는 액션 메소드의 파라미터 변수에 전달된다.
//
//request parameter의 종류
//query string 과 입력 폼
//
//request method란
//HTTP request의 method는,
//이 요청이 어떤 종류의 작업을 서버에 요청하는 것인지 구분하기 위한 속성이다.
//HTTP request의 method를, 요청 방식 정도로 해석하자.

