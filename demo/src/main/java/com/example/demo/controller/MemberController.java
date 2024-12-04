package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.AddMemberRequest;
import com.example.demo.model.service.BlogService;
import com.example.demo.model.service.MemberService;
import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService; // 최상단 서비스 클래스 연동 추가
import java.util.List;
@Controller // 컨트롤러에 이런식으로 연동해주겠다! 라는 뜻 이런식으로 경로를 다 지정해주어야 한다.
//왜 지정을 할까?? 
public class MemberController {
    @Autowired
    MemberService memberService;
    @GetMapping("/join_new") // 회원 가입 페이지 연결
public String join_new() {
return "join_new"; // .HTML 연결
}
@PostMapping("/api/members") // 회원 가입 저장
public String addmembers(@ModelAttribute AddMemberRequest request) {
memberService.saveMember(request);
return "join_end"; // .HTML 연결
}
}
