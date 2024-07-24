import java.util.*;

class Solution {
    public int solution(String before, String after) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : after.split("")) {
            list.add(s);
        }
        
        for (String s : before.split("")) {
            list.remove(s);
        }
        
        if (list.size() == 0) {
            return 1;
        }
        return 0;
    }
}