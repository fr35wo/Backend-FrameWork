package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;

@Controller
@RequestMapping("form")
public class FormController {

    @Autowired DepartmentMapper departmentMapper;

    @GetMapping("edit1")
    public String edit1(Model model) {
        model.addAttribute("student", new Student());
        return "form/edit1";
    }

    @PostMapping("edit1")
    public String edit1(Model model, Student student) {
        // TODO: DB 저장 기능을 구현해야 함.
        model.addAttribute("message", "저장했습니다.");
        return "form/edit1";
    }

//    개선할 점
//    학과명과 학과 id 목록이 form/edit1.jsp 소스코드에 등장하는 것은 바람직하지 않다.
//
//    위 문장을 개발자 용어로 표현하면, 다음과 같다.
//
//    학과명과 학과 id 목록이 하드 코딩(hard coding)된 것은 바람직하지 않다.
//
//    학과명가 학과 id 목록을 DB에서 조회해서, 출력해야 한다.

    //edit2로 개선

    @GetMapping("edit2")
    public String edit2(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentMapper.findAll());
        return "form/edit2";
    }

    @PostMapping("edit2")
    public String edit2(Model model, Student student) {
        // TODO: DB 저장 기능을 구현해야 함.
        model.addAttribute("departments", departmentMapper.findAll());
        model.addAttribute("message", "저장했습니다.");
        return "form/edit2";
    }

    @GetMapping("edit3")
    public String edit3(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentMapper.findAll());
        return "form/edit3";
    }

    @PostMapping("edit3")
    public String edit3(Model model, Student student) {
        // TODO: DB 저장 기능을 구현해야 함.
        model.addAttribute("departments", departmentMapper.findAll());
        model.addAttribute("message", "저장했습니다.");
        return "form/edit3";
    }

}


//소스코드 분석 실습
//저장 버튼을 누른 후, 서버에서 @PostMapping("edit1") 액션 메소드가 실행되고, 다시 출력된 학생 수정 화면에서, 이름 입력 칸에 홍길동 값이 채워져 있는 이유는 무엇인가? 학과 목록에서 소프트웨어공학과가 선택되어 있는 이유는 무엇인가?
//
//이 질문들에 답을 할 수 없다면,
//"01 mybatis 시작" 강의노트의, "수정 기능 실행 과정 설명", "등록 기능 실행 과정 설명" 부분을 꼼꼼히 읽어 보라. 위 질문들에 답을 할 수 없다면, 백엔드 개발자가 될 수 없다.
//
//
//답:
//(1) 저장 버튼을 누르면, 입력 폼에 입력된 데이터는 서버에 전송되어,
//    student 파라미터 객체의 내부에 채워진다.
//(2) student 파라미터 객체는 자동으로 model에 addAttribute 되어, edit.jsp 뷰에 전달된다.
//(3) edit.jsp 뷰에서 입력 폼을 다시 출력할 때, student 객체의 내부 값도 같이 출력된다.
//(4) 이렇게 출력된 값이, 입력 폼에 채워진 상태로 입력 폼이 웹브라우저 창에 그려진다.
