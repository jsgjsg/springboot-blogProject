package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.BoardService;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class BoardApiController {   // board 관련 data를 반환하는 Controller

    @Autowired
    private HttpSession session;    // session 의 principal 에 로그인 시 user정보가 저장됨
    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board) { // 글 작성 method

        User user =  (User)session.getAttribute("principal");   // 로그인 중인 user 정보 가져옴
        boardService.boardWrite(board, user);   // 글 작성 시 username 정보를 함께 등록

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);  // 성공했다는 메시지를 응답
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id) { // 글 삭제 method
        boardService.boardDelete(id);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);   // 성공했다는 메시지를 응답
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board) {    // 글 수정 method
        boardService.boardUpdate(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);   // 성공했다는 메시지를 응답
    }
}