package com.example.responders.parser.news;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsParser {

    private String url = "https://habr.com/ru/news/";

    public List<String> parserNews(){
        List<String> listNews = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).
            timeout(5000).get();
            Elements news = doc.getElementsByClass("tm-article-snippet__title-link");
            for(Element el : news){
                listNews.add(el.text() + "\n");
//                listNews.add(" https://habr.com" + el.select("a").attr("href"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listNews;
    }
}
