class Solution {
    public String[] solution(String my_str, int n) {
        int length = 0;
        if (my_str.length() % n != 0) {
            length = my_str.length() / n + 1;
        } else {
            length = my_str.length() / n;
        }
        
        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            answer[i] = ""; // 각 요소를 빈 문자열로 초기화
        }
        
        int index = 0;
        for (int i = 0; i < my_str.length(); i++) {
            if (answer[index].length() < n) {
                answer[index] += my_str.charAt(i);
            } else {
                index++;
                answer[index] += my_str.charAt(i);
            }
        }
        
        return answer;
    }
}