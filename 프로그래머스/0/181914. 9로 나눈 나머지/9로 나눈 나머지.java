import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        int digits = 0;
        int result = 0;
        for (String s : number.split("")) {
            digits += Integer.valueOf(s);
        }
        
        BigInteger bigInteger = new BigInteger(number);
        
        if (bigInteger.mod(BigInteger.valueOf(9)).intValue() == digits % 9) {
            result = bigInteger.mod(BigInteger.valueOf(9)).intValue();
        }
        return result;
    }
}