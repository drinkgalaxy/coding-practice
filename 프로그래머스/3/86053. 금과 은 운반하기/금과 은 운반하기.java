class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long min = 0L;
        long max = (2000000000L * 200000L);
        long mid;
        
        while (min < max) {
            mid = (min + max) / 2;
            if (IsPossible(a, b, g, s, w, t, mid)) {
                max = mid; // 최대를 --
            } else {
                min = mid + 1; // 최소를 ++
            }
        }
        
        // 최소 시간을 구해야 하므로 max 리턴
        return max;
    }
    
    public static boolean IsPossible(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        long allG = 0L;
        long allS = 0L;
        long allGS = 0L;
        
        long G = 0L;
        long S = 0L;
        long GS = 0L;
        
        long count;
        for (int i = 0; i < g.length; i++) {
            count = time / (t[i] * 2L); // 왕복 이동 가능 횟수
            if (time % (t[i] * 2L) >= t[i]) {
                count++;
            }
            
            G = Math.min(count * w[i], g[i]);
            S = Math.min(count * w[i], s[i]);
            GS = Math.min(count * w[i], g[i] + s[i]);
            
            allG += G;
            allS += S;
            allGS += GS;
        }
        
        if (allG < a || allS < b || allGS < a + b) {
            return false;
        } else {
            return true;
        }
       
    }
}