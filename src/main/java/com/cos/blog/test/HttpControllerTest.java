package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

// @Controller: 사용자 요청에 "HTML file"로 응답하는 controller
// @RestController: 사용자 요청에 "DATA"로 응답하는 controller
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest:";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = Member.builder().username("ming2").password("1213").email("ming2@gmail.com").build();
//        Member m = new Member(1, "ming1", "4567", "ming1@gmail");
        System.out.println(TAG + "getter: " + m.getUsername());
        m.setUsername("ming22222");
        System.out.println(TAG + "getter: " + m.getUsername());
        return "lombok test 완료";
    }

// localholst:8080/http/get (select)
//    localhost:8080/http/get?id=1919&username=ming&password=1212
//    get방식으로 요청시에는 query string으로만 전달 가능
    @GetMapping("/http/get")
    public String getTest(Member m) {

//         parameter를 하나씩 받을 때는 Member m 대신에 @RequestParam int id, @RequestParam String username 형식으로 받으면 됨
//        return "get 요청: " + id + ", " + username;

        return "get 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword();
    }

// localholst:8080/http/post (insert)
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
//        return "post 요청: " + text;
        return "post 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

// localholst:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

// localholst:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
