import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        int digits = 0;
 
        for (String s : number.split("")) {
            digits += Integer.valueOf(s);
        }
        
        return digits % 9;
    }
}