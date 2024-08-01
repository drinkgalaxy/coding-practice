class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        
        int last = num_list[num_list.length - 1];
        int before = num_list[num_list.length - 2];
        
        for (int i = 0; i < num_list.length; i++) {
            if (i == num_list.length - 1) {
                if (last > before) {
                    answer[answer.length - 1] = last - before;
                } else {
                    answer[answer.length - 1] = last * 2;
                }
            }
            answer[i] = num_list[i];
            
        }
        
        return answer;
    }
}