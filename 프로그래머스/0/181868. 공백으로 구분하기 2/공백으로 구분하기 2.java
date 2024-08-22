import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> list = new ArrayList<>();
        
        for (String s : my_string.split(" ")) {
            System.out.println(s);
            if (s.length() > 0) {
                list.add(s);
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