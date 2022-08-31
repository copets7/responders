package com.example.responders.parser.weather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherParser {
    private final String url = "https://world-weather.ru/pogoda/belarus/grodno/";

    public String weatherParser() {
        Document doc = null;
        String weather = null;
        try {
            doc = Jsoup.connect(url).
                    timeout(5000).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Element element = doc.getElementById("weather-now-number");
        assert element != null;
        weather = "В Гродно сейчас " + element.text();
        return weather;
    }

}
