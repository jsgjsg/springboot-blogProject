package com.cos.blog.repository;

import com.cos.blog.model.Board;
import com.cos.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Page<Board> findByCategory(Category category , Pageable pageable); // category를 이용해 select하는 코드

}
