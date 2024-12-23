class Solution {
    public int solution(int number, int limit, int power) {

        int answer = 0;
        for (int i = 0; i < number; i++) {
           answer += getCount(i+1) <= limit ? getCount(i+1) : power;
        }
        return answer;
    }
    
    public static int getCount(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++; // 큰 약수 (i와 n / i가 다르면 추가)
                }
            }
        }
        return count;
    }
}