class Solution {
    public String solution(String bin1, String bin2) {
        int result = changeToNumber(bin1) + changeToNumber(bin2);
        return changeToBinary(result);
    }
    
    public int changeToNumber(String b) {
        return Integer.parseInt(b, 2);
    }
    
    public String changeToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        return Integer.toString(n, 2);
    }
}