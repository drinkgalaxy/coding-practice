class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        
        String value = sb.append(Long.toString(n)).reverse().toString();
        
        int[] answer = new int[value.length()];
        int idx = 0;
        for (String s : value.split("")) {
            answer[idx++] = Integer.parseInt(s);
        }
        
        return answer;
    }
}