package com.cos.blog.service;

import com.cos.blog.model.Board;
import com.cos.blog.model.Category;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService { // board에 관련된 서비스

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void boardWrite(Board board, User user) { // 글 등록
        board.setCount(0); // 조회수 0으로 초기화, 조회수 미구현
        board.setUser(user); // board와 user이 1대다 관계로 조인되어 있음, 로그인 되어있는 user정보 set

        boardRepository.save(board); // INSERT
    }

    @Transactional(readOnly = true) // select 이므로 readOnly
    public Page<Board> boardList(Pageable pageable) { // 글 목록

        return boardRepository.findAll(pageable); // 페이징 해서 select
    }

    @Transactional(readOnly = true)
    public Page<Board> specificList(Pageable pageable, Category category) { // 특정 카테고리 글 목록

        return boardRepository.findByCategory(category, pageable); // 특정 카테고리 글의 개수에 맞게 페이징해서 select
    }

    @Transactional(readOnly = true)
    public Board boardDetail(int id) { // 글 상세보기
        return boardRepository.findById(id)
                .orElseThrow(()-> {
                    return new IllegalArgumentException("글 상세보기 실패 : 글을 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void boardDelete(int  id) { // 글 삭제
        boardRepository.deleteById(id); // DELETE
    }

    @Transactional
    public void boardUpdate(int id, Board requestBoard) { // 글 수정
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> {
                    return new IllegalArgumentException("글 찾기 실패 : 글을 찾을 수 없습니다.");
                });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        board.setCategory(requestBoard.getCategory()); // method 종료 시 변경 내용 UPDATE됨
    }
}
