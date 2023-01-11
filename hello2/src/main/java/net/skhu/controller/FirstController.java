package net.skhu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.Product;


@RestController
//레스트 컨트롤러의 액션 메소드의 리턴값은 데이터이다.
//그 데이터가 웹브라우저에 전송된다.
//레스트 컨트롤러의 액션 메소드가 리턴하는 것이 String 문자열이면, 그 문자열이 웹브라우저에 그대로 전송된다.
//레스트 컨트롤러의 액션 메소드가 리턴하는 것이 배열이나 Java 객체이면, JSON 형태로 변환되어 웹브라우저에 전송된다.

@RequestMapping("first")
public class FirstController {

    @RequestMapping("test1")
    public String test1() {
        return "안녕하세요";
    }

    @RequestMapping("test2")
    public String[] test2() {
        return new String[] { "월", "화", "수", "목", "금", "토", "일" };
    }

    @RequestMapping("test3")
    public Product test3() {
        return new Product("맥주", 2000);
    }

    @RequestMapping("test4")
    public Product[] test4() {
        return new Product[] {
            new Product("맥주", 2000),
            new Product("우유", 1500)
        };
    }

}
