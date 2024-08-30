class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (String s : order) {
            answer += (s.contains("latte")) ? 5000 : 4500;
        }
        return answer;
    }
}