class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long min = 1L;
        // 최대 적재량이 1이고 편도 이동시간이 100000 일 때 시간 최대
        // => (a+b)의 최댓값 * 왕복 최대 시간
        long max = (2000000000) * 200000L;
        long mid;
        
        while (min < max) {
            mid = (min + max) / 2;
            
            if (IsPossible(mid, a, b, g, s, w, t)) { // 만족하면 더 작은 최소시간 시도
                max = mid;
            } else {
                min = mid+1;
            }
        }
        return max;
    }
    
    boolean IsPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long maxTotalG = 0L;
        long maxTotalS = 0L;
        long maxTotalGS = 0L;
        long maxG, maxS, maxGS = 0L;
        
        long count = 0L;
        for (int i = 0; i < g.length; i++) {
            count = time / (t[i] * 2L);
            if (time % (t[i] * 2L) >= t[i]) { // 편도로 한번 더!
                count++;
            }
            
            maxG = Math.min(w[i] * count, g[i]);
            maxS = Math.min(w[i] * count, s[i]);
            maxGS = Math.min(w[i] * count, g[i] + s[i]);
            
            maxTotalG += maxG;
            maxTotalS += maxS;
            maxTotalGS += maxGS;
        }

        
        // count 번 금 또는 은 옮겼는데 필요량 충족 X -> 시간 내에 못 옮김
        if (maxTotalG < a || maxTotalS < b) {
            return false;
        }
        // count 번 금과은 옮겼는데 필요량 충족 X -> 시간 내에 못 옮김
        if (maxTotalGS < a+b) {
            return false;
        }
        return true;
    }
}