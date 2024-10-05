class Solution {
    public int lengthOfLastWord(String s) {
        boolean found = false;
        int buffer = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && !found) {
                found = true;
                buffer = s.length() - 1 - i;
            }
            

            if (s.charAt(i) == ' ' && found) 
            return(s.length() - i - 1 - buffer);
        }
        return(s.length() - buffer);
    }
}
