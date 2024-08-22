import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                list.add(strArr[i]);
            }
        }
        
        String[] answer = new String[list.size()];
        int index = 0;
        for (String s : list) {
            answer[index++] = s;
        }
        return answer;
    }
}