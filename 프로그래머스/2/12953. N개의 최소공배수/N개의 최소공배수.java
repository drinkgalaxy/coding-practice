class Solution {
    public int solution(int[] arr) {
        int temp = LCM(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            temp = LCM(temp, arr[i]);
        }
        return temp;
    }
    
    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
    
    private int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
}