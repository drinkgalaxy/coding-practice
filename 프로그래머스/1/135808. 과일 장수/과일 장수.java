import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.sort(score);
        
        for (Integer i : score) {
            stack.push(i);
        }
        
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            list.add(stack.pop());
            if (list.size() == m) {
                answer += list.get(list.size()-1) * m;
                list.clear(); // 리스트 초기화
            }
        }
        
        return answer;
    }
}