class Solution {
    public int findNonMinOrMax(int[] nums) {
        // 최솟값 구하기
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }

        // 최댓값 구하기
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        // 위 2개 값 제외하고 아무거나 가져오기
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != min && nums[i] != max) {
                return nums[i];
            }
        }
        return -1;
    }
}
