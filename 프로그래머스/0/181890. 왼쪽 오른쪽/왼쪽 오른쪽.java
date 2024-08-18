import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        ArrayList<String> list = new ArrayList<>();
        
        String check = "";
        for (String s : str_list) {
            check += s;
        }
        
        if (check.contains("l") || check.contains("r")) {
            for (int i = 0; i < str_list.length; i++) {
                if (str_list[i].equals("l")) {
                    for (int j = 0; j < i; j++) {
                        list.add(str_list[j]);
                    }
                    break;
                } else if (str_list[i].equals("r")) {
                    for (int j = i+1; j < str_list.length; j++) {
                        list.add(str_list[j]);
                    }
                    break;
                }
            }
        } else {
            String[] answer = new String[0];
            return answer;
        }

        String[] answer = new String[list.size()];
        int index = 0;
        for (String s : list) {
            answer[index++] = s;
        }
        
        return answer;
    }
}