class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] A = nums1;
        int[] B = nums2;

        int m = A.length;
        int n = B.length;

        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : A[i];

            int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                } else {
                    int leftMax = Math.max(Aleft, Bleft);
                    int rightMin = Math.min(Aright, Bright);

                    return ((double) leftMax + (double) rightMin) / 2.0;
                }
            }

            else if (Aleft > Bright) {
                right = i - 1;
            }

            else {
                left = i + 1;
            }
        }

        return -1.0;
    }
}
