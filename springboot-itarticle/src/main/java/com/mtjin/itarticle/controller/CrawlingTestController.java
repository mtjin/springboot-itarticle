package com.mtjin.itarticle.controller;

import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class CrawlingTestController {
    @GetMapping(value = "/crawling")
    public String goRegister() throws IOException {
        Document doc = Jsoup.connect("https://androidweekly.net/").get();
        Elements infoList = doc.select("div[class=sections]").select("a[class=article-headline]");
        Elements contentList = doc.select("span.main-url + p");
        for (int i = 0; i < infoList.size(); i++) {
            //제목
            System.out.println(infoList.get(i).text());
            //링크
            System.out.println(infoList.get(i).attr("href"));
            //이미지 url
            String imageUrl = doc.select("a[href=" + infoList.get(i).attr("href") + "]").select("img").attr("src");
            System.out.println(imageUrl);
            //내용
            String content = contentList.get(0).text();
            System.out.println(content);

        }
        return "views/login/register";
    }
}
