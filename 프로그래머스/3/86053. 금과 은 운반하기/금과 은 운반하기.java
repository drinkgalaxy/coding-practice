class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        
        long min = 0L;
        long max = 400000000000000L;
        long mid;
        
        // 이분 탐색
        while (min < max) {
            mid = (min + max) / 2;
            
            // mid 시간에 (a, b) kg 를 옮길 수 있는가?
            if (IsPossible(mid, a, b, g, s, w, t)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }
    
    public boolean IsPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int n = g.length; 
        // time 시간 동안 옮길 수 있는 최대 금, 은 적재 가능 무게
        long totalG = 0L;
        long totalS = 0L;
        long total = 0L;
        
        // i 번째 도시에서 time 시간동안 옮길 수 있는 최대 금, 은 적재 가능 무게
        long maxG, maxS, maxT;
        
        // time 시간 동안 편도로 움직일 수 있는 횟수
        long count;
        
        for (int i = 0; i < n; i++) {
            count = time / (t[i] * 2L); // time 시간 / 왕복 시간 = 편도로 움직일 수 있는 횟수
            if (time % (t[i] * 2L) >= t[i]) {
                count++;
            }
            
            // count 번 움직여서 옮길 수 있는 최대랑 vs (가진 금 총량, 가진 은 총량, 가진 금+은 총량)
            maxG = Math.min(w[i] * count, g[i]);
            maxS = Math.min(w[i] * count, s[i]);
            maxT = Math.min(w[i] * count, g[i] + s[i]);
            
            totalG += maxG;
            totalS += maxS;
            total += maxT;
        }
        
        // count 번 금/은 하나만 옮겼는데 필요량 충족 X => 시간 내에 불가능
        if (totalG < a || totalS < b) {
            return false;
        }
        
        // count 번 옮길 수 있는 최대를 옮겼는데 필요량 충족 X => 시간 내에 불가능
        if (total < a + b) {
            return false;
        }
        
        return true;
    }
}