import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (String s : myString.split("x")) {
            System.out.println("s = "+s);
            list.add(s.length());
        }
        if (myString.charAt(myString.length() - 1) == 'x') {
            list.add(0);
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            answer[index++] = i;
        }
        return answer;
    }
}