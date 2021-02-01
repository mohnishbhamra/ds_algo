package com.blah;

import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        /*String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        printOutput(groupAnagrams(input));*/

        Tree root = new Tree(1);
        root.insertComplete(root,2);
        root.insertComplete(root,3);
        root.insertComplete(root,4);
        root.insertComplete(root,5);
        root.insertComplete(root,6);
        root.insertComplete(root,7);

        root.insertComplete(root,8);
        root.insertComplete(root,9);
        root.insertComplete(root,10);
        root.insertComplete(root,11);
        root.insertComplete(root,12);
        root.insertComplete(root,13);
        root.insertComplete(root,14);
        root.insertComplete(root,15);



        Tree.printLevelOrder(root);
        Tree.printZigZac(root);

    }

    static public void printOutput(ArrayList<ArrayList<String>> output) {
        int outleng = output.size();
        System.out.println("[");
        for (int i = 0; i < outleng; i++) {
            List<String> innerList = output.get(i);
            int inList = innerList.size();
            for (int j = 0; j < inList; j++) {
                System.out.print(innerList.get(j) + " ,");
            }
            System.out.println();
        }
        System.out.println("]");
    }


    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        /*if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());*/

        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        TreeMap<String, ArrayList<String>> tm = new TreeMap<String, ArrayList<String>>();

        String sorArr;

        for (int i = 0; i < strs.length; i++) {

            sorArr = sortedStr(strs[i]);

            if (tm.containsKey(sorArr)) {
                ArrayList<String> ls = tm.get(sorArr);
                ls.add(strs[i]);
                tm.put(sorArr, ls);

            } else {
                List<String> ls = new ArrayList<String>();
                ls.add(strs[i]);
                tm.put(sorArr, (ArrayList<String>) ls);
            }


        }


        for (String ls : tm.keySet()) {

            list.add(tm.get(ls));

        }

        return list;
    }


    public static String sortedStr(String str) {

        char[] ch = str.toCharArray();
        String res = "";
        TreeSet<Character> ts = new TreeSet<Character>();

        for (int i = 0; i < ch.length; i++) {
            ts.add(ch[i]);
        }
        for (Character c : ts) {
            res = res + c;
        }
        return res;

    }

}
