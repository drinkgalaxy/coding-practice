import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<String> set = new LinkedHashSet<>();
        for (String str : my_string.split("")) {
            set.add(str);
        }
        for (String str : set) {
            answer += str;
        }
        return answer;
    }
}