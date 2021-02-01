package com.blah;

import java.util.*;

class Solution4 {
    public int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return 1;
        }
        int map[] = new int[N+1];

        for (int i = 0; i < trust.length; i++) {
            map[trust[i][1]]++;
        }
        int trustFactor = N - 1;

        for (int key = 0; key < N; key++) {
            if (map[key] == trustFactor) {
                boolean shouldReturn = true;
                for (int i = 0; i < trust.length; i++) {
                    if (trust[i][0] == key) {
                        shouldReturn = false;
                        break;
                    }
                }
                if (shouldReturn) {
                    return key;
                }
            }
        }

        return -1;
    }
}