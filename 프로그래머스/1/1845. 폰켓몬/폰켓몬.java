import java.util.*;


class Solution {
    public int solution(int[] nums) {
        Set<Integer> phoneketmon = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            phoneketmon.add(nums[i]);
        }
        int answer;
        if (phoneketmon.size() >= nums.length/2) {
            answer = nums.length/2;
        } else {
            answer = phoneketmon.size();
        }
        return answer;
    }
}