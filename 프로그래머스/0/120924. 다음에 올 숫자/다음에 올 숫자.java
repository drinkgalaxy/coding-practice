class Solution {
    public int solution(int[] common) {
        // 등차면 true, 등비면 false;
        boolean check = (common[1] - common[0]) == (common[2] - common[1]);
        
        if (check) {
            int plus = common[1] - common[0];
            return common[common.length - 1] + plus;
        } else {
            int multi = common[1] / common[0];
            return common[common.length - 1] * multi;
        }
    }
}