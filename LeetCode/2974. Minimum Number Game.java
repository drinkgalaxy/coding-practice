class Solution {
    public int[] numberGame(int[] nums) {
        int[] resultArray = new int[nums.length];
        if (nums.length != 0) {
            Stack<Integer> stack = new Stack<>();
            Arrays.sort(nums);
            for (int i = nums.length-1; i >= 0; i--) {
                stack.push(nums[i]);
            }
            int index = 0;
            while (!stack.isEmpty()) {
                int alicePick = stack.pop();
                int bobPick = stack.pop();

                resultArray[index] = bobPick;
                index++;
                resultArray[index] = alicePick;
                index++;
            }
            return resultArray;

        } else {
            return nums;
        }
        
    }
}
