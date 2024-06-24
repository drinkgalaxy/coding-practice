class Solution {
    public int solution(int n) {
        int answer = 1;
        int count = 1; // 1인당 먹는 피자의 개수
        // n을 6으로 나눴을 때 나머지가 0인 answer 순간
        while ((n * count) % 6 != 0) {
            count++;
            // (10 * 1) % 6 = 4, count = 1
            // (10 * 2) % 6 = 2, count = 2
            // (10 * 3) % 6 = 0, count = 3 즉 1명이 3개씩 먹어야됨
        }
        return (n * count) / 6 ;
    }
}