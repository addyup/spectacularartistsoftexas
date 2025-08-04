package com.tv.tv;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
@CrossOrigin(origins = "*")
public class NewsScraper {

    @Autowired
private static Document doc;

     @GetMapping("/tc")
  public List<String> soundStacksHealth() throws Exception{
     doc = Jsoup.connect("https://techcrunch.com/").get();
     
        Element div = doc.selectFirst("div.wp-block-columns");

            


 List<String> elementStrings = new ArrayList<>();

        if (div != null) {
            Elements children = div.children();  // Only direct children. Use div.select("*") for all descendants

            for (Element child : children) {
                elementStrings.add(child.outerHtml());
            }
        }

        
    
    return elementStrings;
      }
      
    
}
