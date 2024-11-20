class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % 2 == 0) {
            int mid = s.length() / 2;
            sb.append(s.charAt(mid-1)).append(s.charAt(mid));
        } else {
            int mid = s.length() / 2;
            sb.append(s.charAt(mid));
        }
        return sb.toString();
    }
}