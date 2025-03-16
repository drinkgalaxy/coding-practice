import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(list);
        
        String[] arr = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            arr[idx++] = s.substring(1, s.length());
        }
        return arr;
    }
}