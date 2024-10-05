class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] output = new int[m + n];
        int one = 0;
        int two = 0;
        int i = 0;
        while (one < m && two < n) {
            if (nums1[one] < nums2[two]) {
                output[i] = nums1[one];
                one++;
            } else {
                output[i] = nums2[two];
                two++;
            }
            i++;
        }
        if (one < m) {
            while (i < m + n) {
                output[i] = nums1[one];
                one++;
                i++;
            }
        } else if (two < n) {
            while (i < m + n) {
                output[i] = nums2[two];
                two++;
                i++;
            }
        }
        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = output[j];
        }
    }
}
