package com.blah;

import java.util.PriorityQueue;

public class Solution7 {
    PriorityQueue<Character> minHeap;
    char charArray[];
    char maskArray[];
    int low, high;

    public String removeKdigits(String num, int k) {
        String ans = num;
        int length = num.length();
        if (length == k) {
            return "0";
        }
        low = 0;
        high = length - 1;

        charArray = num.toCharArray();
        maskArray = new char[length];
        minHeap = new PriorityQueue<>(length - k);
        for (int i = 0; i < length; i++) {
            if(charArray[i]!='0')
            minHeap.add(charArray[i]);
        }

        ans=construcSmallest(num, k);
        System.out.println("\nANS = " + ans);
        /*System.out.println("queue");
        while (minHeap.size() != 0) {
            System.out.print(minHeap.remove());
        }
        System.out.println("\nend");*/
        return ans;
    }

    String construcSmallest(String string, int size) {
        String ans = "";
        if (size == 0) {
            Character val = minHeap.remove();
            int pos = string.indexOf(val);
            if (pos >= low & pos <= high) {
                maskArray[pos] = '-';
                ans += val;
                low=pos+1;
            }

            return ans;
        }

        ans = construcSmallest(string, size - 1);
        System.out.println("size = " + size + " ans = " + ans);

        Character val = minHeap.remove();
        int pos = string.indexOf(val, low);
        if (pos >= low & pos <= high) {
            maskArray[pos] = '-';
            ans = pickAns();
            low=pos+1;
        } else if (low <= high) {
            char smallestChar = bringSmallestChar();
            pos = string.indexOf(smallestChar, low);
            maskArray[pos] = '-';
            makeGap();
            minHeap.add(val);
            ans = pickAns();
        }


        return ans;
    }

    private String pickAns() {
        String ans = "";
        int len = charArray.length;
        int i = 0;
        for (; i < len; i++) {
            if (maskArray[i] == '-') {
                ans += charArray[i];
            }
        }
        return ans;
    }

    private char bringSmallestChar() {
        int len = charArray.length;
        int i = low;
        char min = '9';
        for (; i <= high; i++) {
            if (min < charArray[i]) {
                min = charArray[i];
            }
        }
        return min;
    }

    private void makeGap() {
        int len = charArray.length;
        int i = len - 1;
        for (; i >= 0; i--) {
            if (maskArray[i] != '-') {
                high = i;
                i--;
                break;
            }
        }

        for (; i >= 0; i--) {
            if (maskArray[i] != '-') {
                low = i;
                break;
            }
        }
    }
}
