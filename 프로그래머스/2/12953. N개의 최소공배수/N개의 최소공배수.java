class Solution {
    public int solution(int[] arr) {
        int answer = LCM(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            answer = LCM(answer, arr[i]);
        }
        return answer;
    }
    
    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
    
    private static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
}