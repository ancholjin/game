package com.no3.game.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {
    @GetMapping("/register")
    public  void  register(){


    }

}
