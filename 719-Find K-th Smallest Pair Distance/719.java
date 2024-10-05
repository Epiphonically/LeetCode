class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; //lowest difference
        int right = nums[nums.length - 1] - nums[0]; //highest differenece
        int guess = left + ((right - left) / 2);
        while (left < right) {
            if (howManyLessThanGuess(guess, nums) >= k) { //answer is <= guess 
                right = guess; //guess COULD be right or could not be since could be = to k
                guess = left + ((right - left) / 2);
            } else if (howManyLessThanGuess(guess, nums) < k) { //answer is > guess
                left = guess + 1; //guess is completely wrong since if guess was right you would have = case
                guess = left + ((right - left) / 2);
            }

        }
        return guess;
    }

    private int howManyLessThanGuess(int guess, int[] nums) { //Write this in O(n) and you win lol
        int output = 0;
        int right = 0;
        for (int left = 0; left < nums.length; left++) {

            while (right < nums.length && (nums[right] - nums[left] <= guess)) {
                right++;
               
            }
            output += right - left - 1;
        }
        return output;
    }
}
