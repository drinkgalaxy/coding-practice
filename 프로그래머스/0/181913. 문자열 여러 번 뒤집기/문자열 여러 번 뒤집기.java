class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            // 문자열 뒤집기
            StringBuilder sub = new StringBuilder();
            sub.append(sb.substring(start, end+1)).reverse();

            
            for (int j = 0; j < sub.length(); j++) {
                sb.setCharAt(start + j, sub.charAt(j));
            }
        }
        
        return sb.toString();
    }
}