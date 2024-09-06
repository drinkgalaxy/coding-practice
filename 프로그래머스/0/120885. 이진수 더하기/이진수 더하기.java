class Solution {
    public String solution(String bin1, String bin2) {
        return IntegerToBinary(binaryToInteger(bin1) + binaryToInteger(bin2));
        
    }
    
    public int binaryToInteger(String s) {
        return Integer.parseInt(s, 2); 
        // s 가 "1101" 이라면 13을 반환
    }
    
    public String IntegerToBinary(int i) {
        return Integer.toString(i, 2);
        // i 가 23 이라면 "10111" 을 반환
    }
}