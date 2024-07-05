import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[a-z]", "");
        int[] result = new int[my_string.length()];
        int index = 0;
        for (String s : my_string.split("")) {
            result[index] = Integer.valueOf(s);
            index++;
        }
        Arrays.sort(result);
        return result;
    }
}