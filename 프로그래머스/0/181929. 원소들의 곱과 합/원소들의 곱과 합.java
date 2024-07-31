class Solution {
    public int solution(int[] num_list) {
        int multi = 1;
        int add = 0;
        for (Integer i : num_list) {
            multi *= i;
            add += i;
        }
        
        return multi < add * add ? 1 : 0;
        
        
    }
}