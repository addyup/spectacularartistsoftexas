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
     @CrossOrigin(origins = "*")
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

      public int scoresAverage(int[] scores) {
        int middle = scores.length / 2;
        int avg1 = average(scores, 0, middle - 1);
        int avg2 = average(scores, middle, scores.length - 1);

        return Math.max(avg1, avg2);
      }

      public int average(int[] scores, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
          sum += scores[i];
        }
        return sum / (end - start + 1);
      }

      
      //first collect data 
      // Fathers Hands (Calculated Blooming Group) Approved 3 Pending 1 Declined 2
      // WhenBTwannaSeeYa Approved 1 Pending 2 Declined 2
      // Soul Feed Approved 1 Pending 0 Declined 3
      // Celebrate Approved 0 Pending 2 Declined 3
      // 4 quarters in my pocket Approved 2 Pending 1 Declined 5
      // Love Yourz Approved 2 Pending 0 Declined 7
      // Video Games Approved 0 Pending 0 Declined 1
      // DODO BIRD Approved 3 Pending 0 Declined 0
      // Thunderblight Ganon Going Down Approved 3 Pending 0 Declined 0
      // Pray Approved 1 Pending 0 Declined 1
      // hella dreams Approved 0 Pending 0 Declined 3
      // Self Approved 1 Pending 0 Declined 3
      // RISHTA WAY Approved 0 Pending 0 Declined 1

    
}
