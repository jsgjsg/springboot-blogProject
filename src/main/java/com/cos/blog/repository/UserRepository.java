package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password); // 로그인 시 회원 확인하기 위한 코드

    // 위와 같은 코드
//    @Query(value="SELECT * FROM usr WHERE username = ?1 AND password = ?2", nativeQuery = true)
//    User login(String username, String password);
}