class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int count = 0;
        for (String str : cipher.split("")) {
            count++;
            if (count % code == 0) {
                answer += str;
            }
        }
        return answer;
    }
}