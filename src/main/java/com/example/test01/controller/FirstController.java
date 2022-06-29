package com.example.test01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute( "username", "민혁");
        return "greetings"; // 템플릿즈 안에 greetings/mustache를 브라우저로 부름
    }

    @GetMapping("/bye")
    public String byebye(Model model) {
        model.addAttribute("nickname", "민혁");
        return "bye";
    }
}
