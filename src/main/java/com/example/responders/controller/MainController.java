package com.example.responders.controller;

import com.example.responders.parser.news.NewsParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

   private final NewsParser newsParser;

    public MainController(NewsParser newsParser) {
        this.newsParser = newsParser;
    }

    @RequestMapping({"","/"})
    public String index(Model model){
        model.addAttribute("news", newsParser.parserNews() );
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }
}
