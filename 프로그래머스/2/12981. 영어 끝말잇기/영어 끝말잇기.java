import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        
        int turn = 1;
        int num = 1;
        
        list.add(words[0]); // num 1
        for (int i = 1; i < words.length; i++) {
            num = (num % n) + 1;
            if (num == 1) {
                turn++;
            }

            char preWord = words[i-1].charAt(words[i-1].length()-1);
            char afterWord = words[i].charAt(0);
            if (list.contains(words[i]) || preWord != afterWord) {
                answer[0] = num;
                answer[1] = turn;
                return answer;
            } else {
                list.add(words[i]);
            }
        }

        return new int[]{0, 0};
    }
}