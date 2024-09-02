package com.cos.blog.controller;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController { // user 관련 jsp파일을 반환하는 Controller

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @GetMapping("/joinForm")
    public String joinForm() { // 회원가입 페이지 구현

        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() { // 로그인 페이지 구현

        return "user/loginForm";
    }

    @GetMapping("/user/detail/{id}")
    public String userDetail(@PathVariable int id, Model model) { // 회원 정보 보기 구현
        User user = userService.userDetail(id);

        model.addAttribute("user", user);

        return "user/detail";
    }

    @GetMapping("/user/updateForm/{id}")
    public String updateForm(@PathVariable int id, Model model) { // 회원 수정 보기 구현
        model.addAttribute("user", userService.userDetail(id));

        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {    // 로그아웃 구현 ( 메인페이지로 이동 )

        session.removeAttribute("principal");

        return "redirect:/";
    }
}