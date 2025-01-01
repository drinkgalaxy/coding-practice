class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0;
        
        while (idx < s.length()) {
            char x = s.charAt(idx);
            int xCount = 0;
            int otherCount = 0;
            
            while (idx < s.length()) {
                if (s.charAt(idx) == x) {
                    xCount++;
                } else {
                    otherCount++;
                }
                idx++;
                
                if (xCount == otherCount) {
                    break;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}