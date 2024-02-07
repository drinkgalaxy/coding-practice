class Solution {
    public int solution(int[] num_list, int n) {
        int count = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] == n) {
                count = 1;
            } 
        }
        return count;
    }
}    
    
    