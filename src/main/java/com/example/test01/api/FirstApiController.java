package com.example.test01.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI용 컨트롤러 JSON을 변환
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world";
    }
}
