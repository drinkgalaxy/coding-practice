import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            if (list.size() < k) {
                list.add(score[i]);
                Collections.sort(list, Collections.reverseOrder());
                answer[i] = list.get(list.size() - 1); 
            } else if (list.get(list.size() - 1) < score[i]) {
                list.remove(list.size() - 1); // 제일 작은 거 제거
                list.add(score[i]); // 새로운 요소 추가
                Collections.sort(list, Collections.reverseOrder());
                answer[i] = list.get(list.size() - 1); 
            } else {
                answer[i] = list.get(list.size() - 1);
            }
           
        }
        return answer;
    }
}