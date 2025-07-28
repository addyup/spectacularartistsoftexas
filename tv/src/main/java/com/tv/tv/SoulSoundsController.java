package com.tv.tv;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// @author Adwait Uprety

@RestController
@RequestMapping("/health")
public class SoulSoundsController {

    @Autowired
private static Document doc;

     @GetMapping("/alcohol")
     @CrossOrigin(origins = "https://spectacularartistsoftexas.netlify.app")
  public String[] soundStacksHealth() throws Exception{
     doc = Jsoup.connect("https://www.betterhealth.vic.gov.au/health/healthyliving/alcohol").get();
     Element targetDiv = doc.selectFirst(".rpl-markup__inner");

            String[] listedI = new String[targetDiv.childrenSize()];
     if (targetDiv != null) {
            for(int i = 0; i < targetDiv.childrenSize(); i++) {
              listedI[i] = targetDiv.text();
            }
        } 


return listedI;
      }
    
}
