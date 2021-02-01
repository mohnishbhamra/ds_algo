package com.rewindFast;
import java.util.regex.*;
public class PatternAndMatcher {
    public static void main(String args[]){
        Pattern pattern = Pattern.compile("ello");
        Matcher matcher = pattern.matcher("asldhasofhioqhfqeihfqihfpoqhfdafeelloeeello");
        System.out.println(matcher.find());
        

    }
}
