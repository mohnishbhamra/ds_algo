package com.sonpapdi;

import java.util.Arrays;

public class Numberfullbinarytreesnodeproductchildren {


    // Return the number of all possible
    // full binary tree with given product
    // property.
    static int numoffbt(int arr[], int n) {

        // Finding the minimum and maximum
        // values in given array.
        int maxvalue = -2147483647;
        int minvalue = 2147483647;
        for (int i = 0; i < n; i++) {
            maxvalue = Math.max(maxvalue, arr[i]);
            minvalue = Math.min(minvalue, arr[i]);
        }

        int mark[] = new int[maxvalue + 2];
        int value[] = new int[maxvalue + 2];
        Arrays.fill(mark, 0);
        Arrays.fill(value, 0);

        // Marking the presence of each array element
        // and initialising the number of possible
        // full binary tree for each integer equal
        // to 1 because single node will also
        // contribute as a full binary tree.
        for (int i = 0; i < n; i++) {
            mark[arr[i]] = 1;
            value[arr[i]] = 1;
        }

        // From minimum value to maximum value of array
        // finding the number of all possible Full
        // Binary Trees.
        int ans = 0;
        for (int i = minvalue; i <= maxvalue; i++) {

            // Find if value present in the array
            if (mark[i] != 0) {
                // For each multiple of i, less than
                // equal to maximum value of array
                for (int j = i + i;
                     j <= maxvalue && j / i <= i; j += i) {
                    // If multiple is not present in
                    // the array then continue.
                    if (mark[j] == 0)
                        continue;

                    // Finding the number of possible
                    // Full binary trees for multiple
                    // j by multiplying number of
                    // possible Full binary tree from
                    // the number i and number of
                    // possible Full binary tree from i/j.
                    value[j] = value[j] + (value[i]
                            * value[j / i]);

                    // Condition for possiblity when
                    // left chid became right child
                    // and vice versa.
                    if (i != j / i)
                        value[j] = value[j] + (value[i]
                                * value[j / i]);
                }
            }

            ans += value[i];
        }

        return ans;
    }

    //driver code
    public static void main(String[] args) {
        int arr[] = {2, 4, 8, 16, 32};
        int n = arr.length;

        System.out.print(numoffbt(arr, n));
    }
}

//This code is contributed by Anant Agarwal.
