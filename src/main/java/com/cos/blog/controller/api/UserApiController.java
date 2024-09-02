package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {    // user 관련 data를 반환하는 Controller

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {  // 회원가입 method

        user.setRole(RoleType.USER);
        userService.signUp(user);       // Role에 enum의 USER을 저장 후 userService의 signUp method 호출
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user) { // 로그인 method
        User principal = userService.login(user);
        if(principal != null) {
            session.setAttribute("principal", principal);   //session에 principal이라는 변수명으로 로그인한 user 정보 등록
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/user/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody User user) {  // 회원정보 수정 method
        userService.userUpdate(id, user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
