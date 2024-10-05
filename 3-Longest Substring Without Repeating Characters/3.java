class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int currLen = 0;
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        for (int left = 0; left < s.length(); left++) {
            while(right < s.length()) {
                if (!found.containsKey(s.charAt(right))) {
                    found.put(s.charAt(right), 0);
                } else {
                   
               
                    break;
                }
                right++;
            }
             currLen = Math.max(currLen, right - left);
            found.remove(s.charAt(left));
        }
        return currLen;
    }
}
