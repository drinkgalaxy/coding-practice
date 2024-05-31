class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        Double doubleNum1 = Double.valueOf(num1);
        Double doubleNum2 = Double.valueOf(num2);
        Double multi = (doubleNum1 / doubleNum2) * 1000;
        int result = multi.intValue();
        return result;
    }
}