class Solution {
    public int solution(int[][] dots) {
        // 모든 가능한 쌍을 비교
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) {
            return 1;
        }
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) {
            return 1;
        }
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) {
            return 1;
        }
        
        return 0;
    }
    
    // 기울기를 비교하는 함수
    boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        int x1 = dot1[0], y1 = dot1[1];
        int x2 = dot2[0], y2 = dot2[1];
        int x3 = dot3[0], y3 = dot3[1];
        int x4 = dot4[0], y4 = dot4[1];
            
        return (y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1);
    }
}