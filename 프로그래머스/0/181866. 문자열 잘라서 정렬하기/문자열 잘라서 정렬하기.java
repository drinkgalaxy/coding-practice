import java.util.*;

class Solution {
    public String[] solution(String myString) {
        ArrayList<String> list = new ArrayList<>();
        
        for (String s : myString.split("x")) {
            if (!s.equals("")) {
                list.add(s);
            }
        }
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        int index = 0;
        for (String s : list) {
            answer[index++] = s;
        }
        
        return answer;
    }
}