package com.tv.tv;

import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/musicians")
public class SoundStacksController {

  @CrossOrigin(origins = "*")
  @GetMapping("/middleWay/{a}/{b}")
  public int[] middleWay(@PathVariable int[] a,@PathVariable int[] b) {
  return new int[] {a[1], b[1]};
}

  @CrossOrigin(origins = "*")
  @GetMapping
  public List<Musician> getMusicians() {
        return List.of(
            new Musician("Amanda Victoria", "Atlas", "Country Pop"),
            new Musician("Tommy Luke", "McFlys Pub", "Folk Country"),
            new Musician("TRVR?", "Atlas/Tulips", "POP"),
            new Musician("Kayley Ryan", "Atlas/McFlys Pub", "StarWars"),
            new Musician("Lil Sonata", "Royal Lane Studios", "HipHop/Rap"),
            new Musician("Addy Up", "McFlys Pub", "HipHop/Rap"),
            new Musician("Eric the Bourassa", "Atlas", "Future Rock")
        );
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listOfNames")
    public static List<String> namesInAList() {
        return Arrays.asList(
            new String("Bob Barker"),
            new String("Timmy Tommy")
        );
    }

    @PostMapping("tvByGenre")
    public static String tobereakdownIMDB(@RequestBody String ex) {

        try{
        Document doc = Jsoup.connect(ex).get();
        return doc.html();

        }
        catch (Exception e) {
            e.printStackTrace();
        
    }
    return "Couldn't process website.";
}

public boolean commonEnd(int[] a, int[] b) {
  if(a[0] == b[0] || a[a.length-1] == b[b.length-1]) {
    return true;
  }
  return false;
}

public int[] reverse3(int[] nums) {
  int[] reversed = new int[3];
  
  for(int i =0; i< 3; i++) {
    reversed[i] = nums[2-i];
  }
  return reversed;
}

public Object[] reverse3AndcommonEnd(int[] a, int[] b, int[] nums) 
{
    boolean val = false;
     if(a[0] == b[0] || a[a.length-1] == b[b.length-1]) {
    val = true;
  }
   val = false;

int[] reversed = new int[3];
  
  for(int i =0; i< 3; i++) {
    reversed[i] = nums[2-i];
  }
return new Object[] {val, reversed};
}
public int bigDiff(int[] nums) {
  int min = nums[0];
  int max = nums[0];

  for(int i = 1; i < nums.length; i++) {
    min = Math.min(min, nums[i]);
    max = Math.max(max, nums[i]);
  }
  return max - min;
}

public double[] reciprocalVal(double numberToConvertIntoAReciprocal) {
  return new double []{numberToConvertIntoAReciprocal / numberToConvertIntoAReciprocal , numberToConvertIntoAReciprocal};
}


}
