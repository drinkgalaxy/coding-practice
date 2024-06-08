class Solution {
    public int fib(int n) {
        // 1. n이 0 또는 1일 경우 n 리턴
        if (n == 0 || n == 1) {
            return n;
        }
        // 2. 재귀호출로 피보나치 수열 계산 후 리턴
        return (fib(n-1) + fib(n-2));
    }
}
