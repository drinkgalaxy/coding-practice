import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> list = new ArrayList<>();
        for (String s1 : myStr.split("a")) {
            for (String s2 : s1.split("b")) {
                for (String s3 : s2.split("c")) {
                    if (!s3.equals("")) {
                        list.add(s3);
                    }
                }
            }
        } 
        
        if (list.size() == 0) {
            return new String[]{"EMPTY"};
        }
        
        String[] answer = new String[list.size()];
        int index = 0;
        for (String s : list) {
            answer[index++] = s;
        }
        return answer;
    }
}