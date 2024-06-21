import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 논문의 인용 횟수 정렬
        Arrays.sort(citations);
        
        int n = citations.length;
        
        // h의 최댓값 찾기
        for (int i = 0; i < n; i++) {
            int h = n - i; 
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}