import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (map.containsKey(c)) {
                    int idx = map.get(c);
                    map.put(c, Math.min(idx, j+1)); // 더 작은 인덱스를 가진 key를 넣어주기
                } else {
                    map.put(c, j+1);
                }
            }
        }
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            boolean flag = true;
            for (char c : target.toCharArray()) {
                if (map.containsKey(c)) {
                    count += map.get(c);
                } else {
                    flag = false;
                    break;
                }
            }
            answer[i] = flag == false ? -1 : count;
        }
        
        return answer;
    }
}