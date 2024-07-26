import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[my_string.length()];
        
        int index1 = 0;
        for (String s1 : my_string.split("")) {
            arr[index1] = s1;
            index1++;
        }
        
        int index2 = s;
        for (String s2 : overwrite_string.split("")) {
            arr[index2] = s2;
            index2++;
        }
        
        for (String s3 : arr) {
            sb.append(s3);
        }
        
        return sb.toString();
    }
}