class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t <= n) {
            if (t % 2 != 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
            t++;
        }
        return sb.toString();
    }
}