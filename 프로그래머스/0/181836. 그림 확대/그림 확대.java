import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < picture[i].length(); j++) {
                for (int l = 0; l < k; l++) {
                    sb.append(picture[i].charAt(j));
                }
            }
            list.add(sb.toString());
        }
        
        String[] answer = new String[list.size() * k];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < k; j++) {
                answer[index++] = list.get(i);
            }
        }
        
        return answer;
    }
}