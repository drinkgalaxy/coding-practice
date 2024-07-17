class Solution {
    public String[] solution(String my_str, int n) {
        int length = (my_str.length() + n - 1) / n;
        
        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            answer[i] = ""; // 각 요소를 빈 문자열로 초기화
        }
        
        int index = 0;
        for (String s : my_str.split("")) {
            if (answer[index].length() < n) {
                answer[index] += s;
            } else {
                index++;
                answer[index] += s;
            }
        }
        
        return answer;
    }
}