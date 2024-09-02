package com.cos.blog.service;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService { // user에 관련된 서비스

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void signUp(User user) { // 로그인
        userRepository.save(user);
    }

    @Transactional(readOnly = true) // SELECT 할 때 트랜잭션 시작, 서비스 종료 시에 트랜잭션 종료 ( 정합성 )
    public User login(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Transactional(readOnly = true)
    public User userDetail(int id) { // 회원 정보 보기
        return userRepository.findById(id)
                .orElseThrow(()-> {
                    return new IllegalArgumentException("유저 정보 불러오기 실패");
                });
    }

    @Transactional
    public void userUpdate(int id, User requestUser) { // 회원 정보 수정
        User user = userRepository.findById(id)
                .orElseThrow(()-> {
                    return new IllegalArgumentException("회원 찾기 실패 : 회원을 찾을 수 없습니다.");
                });
        System.out.println(user);
        user.setUsername(requestUser.getUsername());
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        System.out.println(user);
    }
}
