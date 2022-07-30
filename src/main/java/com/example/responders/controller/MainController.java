package com.example.responders.controller;

import com.example.responders.parser.news.NewsParser;
import com.example.responders.parser.weather.WeatherParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

   private final NewsParser newsParser;
   private final WeatherParser weatherParser;

    public MainController(NewsParser newsParser, WeatherParser weatherParser) {
        this.newsParser = newsParser;
        this.weatherParser = weatherParser;
    }

    @RequestMapping({"","/"})
    public String index(Model model){
        model.addAttribute("news", newsParser.parserNews() );
        model.addAttribute("weather", weatherParser.weatherParser());
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
