package com.sonpapdi;


// Java code to calculate maximum unique
// element of every segment of array

import java.io.*;
import java.util.*;

class MaxUniqueElementFromSubArray {

    static void find_max(int[] arr, int size, int K) {
        // Storing counts of first K-1 elements
        // Also storing distinct elements.
        HashMap<Integer, Integer> Count = new HashMap<>();
        for (int i = 0; i < K - 1; i++)
            if (Count.containsKey(arr[i]))
                Count.put(arr[i], 1 + Count.get(arr[i]));
            else
                Count.put(arr[i], 1);

        TreeSet<Integer> MyTreeset = new TreeSet<Integer>();
        for (Map.Entry x : Count.entrySet()) {
            if ((Integer)x.getValue() == 1)
                MyTreeset.add((Integer)x.getValue());
        }

        // Before every iteration of this loop,
        // we maintain that K-1 elements of current
        // window are processed.
        for (int i = K - 1; i < size; i++) {

            // Process K-th element of current window
            if (Count.containsKey(arr[i]))
                Count.put(arr[i], 1 + Count.get(arr[i]));
            else
                Count.put(arr[i], 1);

            if (Count.get(arr[i]) == 1)
                MyTreeset.add(arr[i]);
            else
                MyTreeset.remove(arr[i]);

            // If there are no distinct
            // elements in current window
            if (MyTreeset.size() == 0)
                System.out.println("Nothing");

                // Set is ordered and last element
                // of set gives us maximum element.
            else
                System.out.println(MyTreeset.last());

            // Remove first element of current
            // window before next iteration.
            int x = arr[i - K + 1];
            Count.put(x, Count.get(x) - 1);

            if (Integer.parseInt(String.valueOf(Count.get(x))) == 1)
                MyTreeset.add(x);
            if (Integer.parseInt(String.valueOf(Count.get(x))) == 0)
                MyTreeset.remove(x);
        }
    }

    // Driver code
    public static void main(String args[]) {
        int[] arr = {1, 2, 2, 3, 3};
        int size = arr.length;
        int k = 3;
        find_max(arr, size, k);
    }
}

// This code is contributed by rachana soma
