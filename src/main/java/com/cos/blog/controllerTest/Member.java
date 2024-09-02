package com.cos.blog.controllerTest;

import lombok.*;

//@Getter
//@Setter
@Data
@NoArgsConstructor
public class Member { // 공부
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
