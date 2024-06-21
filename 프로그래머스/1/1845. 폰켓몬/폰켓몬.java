import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 최대한 많은 폰켓몬 -> set 으로 중복 제거
        // nums.length 만큼 돌면서 set을 사용해서 저장하고, nums가 없으면 저장후 result++
        // answer가 nums.length/2 보다 크면 nums.length/2 return.
        
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                answer++;
            } 
        }
        
        if (answer >= nums.length/2) {
            return nums.length/2;
        }
        return answer;
    }
}