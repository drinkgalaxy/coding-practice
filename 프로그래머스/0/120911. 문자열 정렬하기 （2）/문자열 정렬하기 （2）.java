import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] arr = new String[my_string.length()];
        
        answer = my_string.toLowerCase();
        
        int index = 0;
        for (String s : answer.split("")) {
            arr[index] = s;
            index++;
        }
        
        Arrays.sort(arr);
        
        answer = "";
        for (String s : arr) {
            answer += s;
        }
        
        return answer;
    }
}