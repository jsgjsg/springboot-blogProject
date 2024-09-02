package com.cos.blog.controllerTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerTest {   // 공부

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = new Member(1, "ssar", "1234", "a@naver.com" );
        System.out.println(TAG + "getter : " + m.getId());
        m.setId(5000);
        System.out.println(TAG + "setter : " + m.getId());

        return "lombok test  완료";
    }

    @GetMapping("/http/get")
    public String getTest(Member m) {
        return("getTest");
    }

    @GetMapping("/test")
    public String test() {
        return("hi");
    }
    @GetMapping("/test2")
    public String test2() {
        return("hi");
    }
}