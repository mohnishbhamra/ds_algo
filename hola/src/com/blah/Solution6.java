package com.blah;

public class Solution6 {
    public int singleNonDuplicate(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        int mid;

        while (low != high) {
            mid = low + ((high - low) / 2);
            System.out.println("mid at " + mid + " and element is " + arr[mid]);
            if ((mid + 1) % 2 == 0) { // if charArray[low-mid] contains even element, there cant be a duplicate if mid and mid-1 are same
                if (arr[mid] == arr[mid - 1]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            } else {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
        }

        return arr[low];
    }
}
