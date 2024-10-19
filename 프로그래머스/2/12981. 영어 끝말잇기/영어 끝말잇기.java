import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {

        ArrayList<String> list = new ArrayList<>();
        int count = 1;
        int num = 1;
        list.add(words[0]); // 첫 단어 미리 추가 
        for (int i = 1; i < words.length; i++) {
            num = (num % n) + 1;
            if (num == 1) { // 한바퀴 돌면
                count++;
            }
            
            char pre = words[i-1].charAt(words[i-1].length()-1);
            char now = words[i].charAt(0);
            if (list.contains(words[i]) || pre != now) {
                return new int[]{num, count};
            } else {
                list.add(words[i]);
            }
        }
    
        return new int[]{0, 0};
    }
}