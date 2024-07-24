class Solution {
    public String solution(String bin1, String bin2) {
        int result = ChangetoNumber(bin1) + ChangetoNumber(bin2);
        return ChangetoBinary(result);
    }
    
    public int ChangetoNumber(String str) {
        int number = Integer.parseInt(str);
        int digit = 0;
        int powNumber = 0;
        int count = 0;
        
        while (number != 0) {
            digit = number % 10; // 각 자릿수 더하기
            if (digit == 1) {
                powNumber += Math.pow(2, count);   
            }
            number /= 10; // 다음 자릿수로 이동
            count++;
        }
        
        return powNumber;
    }
    
    public String ChangetoBinary(int n) {
        if (n == 0) {
            return "0";
        }
        
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.append(n % 2);
            n /= 2;
        }
        
        return binary.reverse().toString();
    }   
}