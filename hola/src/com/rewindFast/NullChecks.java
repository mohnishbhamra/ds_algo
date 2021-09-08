/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 1;
        int index = 1;
        HashMap<Character, Integer> map = new HashMap();

        int i;
        for (i = 0; i < s.length(); i++, index++) {
            char x = s.charAt(i);

            if (map.get(x) == null) {
                map.put(x, index);
            } else {
                int xval = map.get(x);
                if (start <= xval) {
                    int maxSoFar = index - start;
                    if (max < maxSoFar) {
                        max = maxSoFar;
                    }
                    start = xval + 1;
                }
                map.put(x, index);
            }
        }

        int maxSoFar = index - start;
        if (max < maxSoFar) {
            max = maxSoFar;
        }
        return max;
    }
}*/
