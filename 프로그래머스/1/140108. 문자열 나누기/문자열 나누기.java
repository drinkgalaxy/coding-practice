class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < s.length()) {
            char c = s.charAt(idx);
            int isX = 0;
            int isNotX = 0;
            
            while (idx < s.length()) {
                if (s.charAt(idx) == c) {
                    isX++;
                } else {
                    isNotX++;
                }
                idx++;
                
                if (isX == isNotX) {
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}