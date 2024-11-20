package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService; // 최상단 서비스 클래스 연동 추가

@Controller // 컨트롤러에 이런식으로 연동해주겠다! 라는 뜻 이런식으로 경로를 다 지정해주어야 한다.
//왜 지정을 할까?? 
public class DemoController {
    @Autowired
    TestService testService; // DemoController 클래스 아래 객체 생성
    @GetMapping("/hello") // 전송 방식 GET
    public String hello(Model model) {
    model.addAttribute("data", " 방갑습니다."); // model 설정
    return "hello"; // hello.html 연결
    }
    @GetMapping("/testdb")
    public String getAllTestDBs(Model model) {
        TestDB test = testService.findByName( "홍길동");
        model.addAttribute("data4", test);
       
       
        System.out.println("데이터 출력 디버그 : " + test);
        return "testdb";
    }
    // @GetMapping("/article_list")
    // public String article_list() {
    // return "article_list";
    // }4



    @GetMapping("/about_detailed")
    public String about() {
    return "about_detailed";
    }

    @GetMapping("/test1") // 이런"test"식(경로) 으로 접근하겠다는뜻 미리 만들어놓은..
    public String thymeleaf_test1(Model model) {
        model.addAttribute("data1","<h2> 방갑습니다 </h2>");
        model.addAttribute("data2","태그의 속성 값");
        model.addAttribute("link",01);
        model.addAttribute("name", "홍길동");
        model.addAttribute("para1", "001");
        model.addAttribute("para2", 002);
        return "thymeleaf_test1";
        }
    
}