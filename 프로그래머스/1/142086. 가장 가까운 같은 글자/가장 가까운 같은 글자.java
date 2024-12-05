import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] arr = s.split("");
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                answer[i] = -1;
                list.add(arr[i]);
            } else {
                for (int j = i-1; j >= 0; j--) {
                    if (arr[i].equals(arr[j])) {
                        answer[i] = i-j;
                        list.add(arr[i]);
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}