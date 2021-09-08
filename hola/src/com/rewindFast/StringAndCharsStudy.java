package com.rewindFast;

public class StringAndCharsStudy {
    public  static void main(String args[]){
        String a = "200";
        int val = Integer.parseInt("7987");
        int asciCodeOFa = 'a'; //char gets auto box to int
        System.out.println(asciCodeOFa);
        int asciCodeOFA = new Character('A'); //char gets auto box to int
        System.out.println(asciCodeOFA);
        double valx = Double.parseDouble(a);
        System.out.println(val+" "+valx );

        String string = "Hello World!";
        System.out.println("length "+string.length());
        System.out.println("substring "+string.substring(0,2));
        System.out.println("substring i,i is-> d"+string.substring(0,1));
        System.out.println("indexOf "+string.indexOf('l'));
        System.out.println("indexOf from "+string.indexOf('l',string.indexOf('l')+1));
        System.out.println("lastIndexOf "+string.lastIndexOf('l'));
        String pat = "el";
        string.matches(pat);
    }
}
