package com.cos.blog.controller;

import com.cos.blog.model.Category;
import com.cos.blog.model.User;
import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController { // board 관련 jsp파일을 반환하는 Controller

    @Autowired
    private HttpSession session;
    @Autowired
    private BoardService boardService;

    @GetMapping({"", "/"})
    public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.boardList(pageable)); // 기본 페이지 구현, 페이징 구현

        model.addAttribute("categoryURL", "board"); // 게시글의 카테고리를 index에 전달

        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {  // 글 등록 페이지 구현
        return "board/saveForm";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable int id, Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        User user =  (User)session.getAttribute("principal"); // 글 상세 페이지 구현

        model.addAttribute("board", boardService.boardDetail(id));
        model.addAttribute("user", user);
        model.addAttribute("boards", boardService.boardList(pageable));

        model.addAttribute("categoryURL", "board");

        return "index";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) { // 글 수정 페이지 구현
        model.addAttribute("board", boardService.boardDetail(id));

        return "board/updateForm";
    }

    @GetMapping("/diary")
    public String diary(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.specificList(pageable, Category.DIARY));
        // diary 카테고리 게시글만 페이징해서 가져옴 (기본 페이지 그대로 이용)
        model.addAttribute("categoryURL", "diary");

        return "index";
    }

    @GetMapping("/diary/saveForm")
    public String saveDiaryForm(Model model) { // diary 등록 페이지 구현 // diary페이지에서 글 등록 시 카테고리가 diary로 선택되게 함
        model.addAttribute("category", "DIARY");

        return "board/saveForm";
    }

    @GetMapping("/diary/{id}")
    public String diaryDetail(@PathVariable int id, Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        User user =  (User)session.getAttribute("principal"); // diary 상세 페이지 구현

        model.addAttribute("board", boardService.boardDetail(id));
        model.addAttribute("user", user);
        model.addAttribute("boards", boardService.specificList(pageable, Category.DIARY));

        model.addAttribute("categoryURL", "diary");

        return "index";
    }

    @GetMapping("/travel")
    public String travel(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.specificList(pageable, Category.TRAVEL));
        // travel 카테고리 게시글만 페이징해서 가져옴 (기본 페이지 그대로 이용)
        model.addAttribute("categoryURL", "travel");

        return "index";
    }

    @GetMapping("/travel/saveForm")
    public String saveTravelForm(Model model) { // travel 등록 페이지 구현 // travel페이지에서 글 등록 시 카테고리가 travel로 선택되게 함
        model.addAttribute("category", "TRAVEL");

        return "board/saveForm";
    }

    @GetMapping("/travel/{id}")
    public String travelDetail(@PathVariable int id, Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        User user =  (User)session.getAttribute("principal"); // travel 상세 페이지 구현

        model.addAttribute("board", boardService.boardDetail(id));
        model.addAttribute("user", user);
        model.addAttribute("boards", boardService.specificList(pageable, Category.TRAVEL));

        model.addAttribute("categoryURL", "travel");

        return "index";
    }

    @GetMapping("/movie")
    public String movie(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.specificList(pageable, Category.MOVIE));
        // movie 카테고리 게시글만 페이징해서 가져옴 (기본 페이지 그대로 이용)
        model.addAttribute("categoryURL", "movie");

        return "index";
    }

    @GetMapping("/movie/saveForm")
    public String saveMovieForm(Model model) { // movie 등록 페이지 구현 // movie페이지에서 글 등록 시 카테고리가 movie로 선택되게 함
        model.addAttribute("category", "MOVIE");

        return "board/saveForm";
    }

    @GetMapping("/movie/{id}")
    public String movieDetail(@PathVariable int id, Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        User user =  (User)session.getAttribute("principal"); // movie 상세 페이지 구현

        model.addAttribute("board", boardService.boardDetail(id));
        model.addAttribute("user", user);
        model.addAttribute("boards", boardService.specificList(pageable, Category.MOVIE));

        model.addAttribute("categoryURL", "movie");

        return "index";
    }

    @GetMapping("/netflix")
    public String netflix(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.specificList(pageable, Category.NETFLIX));
        // netflix 카테고리 게시글만 페이징해서 가져옴 (기본 페이지 그대로 이용)
        model.addAttribute("categoryURL", "netflix");

        return "index";
    }

    @GetMapping("/netflix/saveForm")
    public String saveNetflixForm(Model model) { // netflix 등록 페이지 구현 // netflix페이지에서 글 등록 시 카테고리가 netflix로 선택되게 함
        model.addAttribute("category", "NETFLIX");

        return "board/saveForm";
    }

    @GetMapping("/netflix/{id}")
    public String netflixDetail(@PathVariable int id, Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        User user =  (User)session.getAttribute("principal"); // netflix 상세 페이지 구현

        model.addAttribute("board", boardService.boardDetail(id));
        model.addAttribute("user", user);
        model.addAttribute("boards", boardService.specificList(pageable, Category.NETFLIX));

        model.addAttribute("categoryURL", "netflix");

        return "index";
    }
}