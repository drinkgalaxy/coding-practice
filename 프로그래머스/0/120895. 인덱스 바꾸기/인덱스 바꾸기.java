class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] stringArr = new String[my_string.length()];
        int index = 0;
        for (String s : my_string.split("")) {
            stringArr[index] = s;
            index++;
        }
        
        String temp = stringArr[num1];
        stringArr[num1] = stringArr[num2];
        stringArr[num2] = temp;
        
        String answer = "";
        for (String s : stringArr) {
            answer += s;
        }
        
        return answer;
    }
}