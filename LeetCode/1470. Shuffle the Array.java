class Solution {
    public int[] shuffle(int[] nums, int n) {

        // n 기준 인덱스로 배열을 나누기
        int[] num1 = new int[n];
        for (int i = 0; i < n; i++) {
            num1[i] = nums[i];
        }
        int[] num2 = new int[n];
        for (int i = 0; i < n; i++) {
            num2[i] = nums[n+i];
        }

        // 배열을 순서대로 섞기
        // 짝수면 num1의 값, 홀수면 num2의 값
        int num1Count = 0;
        int num2Count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                    nums[i] = num1[num1Count];
                    num1Count++;
                } else {
                    nums[i] = num2[num2Count];
                    num2Count++;
                }
        }

        return nums;
    }
}
