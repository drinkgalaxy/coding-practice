import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (Integer i : arr) {
            list.add(i);
        }
        
        // 리스트 크기가 2의 제곱이 될 때까지 0을 추가합니다.
        while (!isPowerOfTwo(list.size())) {
            list.add(0);
        }
        
        // ArrayList를 배열로 변환합니다.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    // n이 2의 제곱인지 확인하는 함수
    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
