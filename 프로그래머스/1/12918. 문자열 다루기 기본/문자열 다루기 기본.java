class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        for (String str : s.split("")) {
            if (48 <= str.charAt(0) && str.charAt(0) <= 57) {
                if (s.length() == 4 || s.length() == 6) {
                } else {
                    return false;
                }
            } else {
                return false;
            }
            
        }
        return answer;
    }
}