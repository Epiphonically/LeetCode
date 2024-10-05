class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
   
        HashMap<Integer, Integer> found = new HashMap<Integer, Integer>();
        int atMostK = 0;
        int atMostOneLess = 0;
        int right = 0;
        for (int left = 0; left < nums.length; left++) { 

            while(right < nums.length && found.size() <= k) {
                if (!found.containsKey(nums[right]) && found.size() == k) {
                    break;
                }
                if (!found.containsKey(nums[right])) {
                    found.put(nums[right], 1);
                } else {
                    found.replace(nums[right], found.get(nums[right]) + 1);
                }
                right++;
            }
            atMostK += right - left;
            found.replace(nums[left], found.get(nums[left]) - 1);
            if (found.get(nums[left]) == 0) {
                found.remove(nums[left]);
            }
        } 
        
        if (k == 1) {
            return atMostK;
        }

        right = 0;
        found.clear();
        
        for (int left = 0; left < nums.length; left++) { 

            while(right < nums.length && found.size() <= k - 1) {
                if (!found.containsKey(nums[right]) && found.size() == k - 1) {
                    break;
                }
                if (!found.containsKey(nums[right])) {
                    found.put(nums[right], 1);
                } else {
                    found.replace(nums[right], found.get(nums[right]) + 1);
                }
                right++;
            }
            atMostOneLess += right - left;
            found.replace(nums[left], found.get(nums[left]) - 1);
            if (found.get(nums[left]) == 0) {
                found.remove(nums[left]);
            }
        }
        return atMostK - atMostOneLess;
    }
}
