class Solution {
    public int solution(int hp) {
        int answer = 0;
        // 장군개미 = 5, 병정개미 = 3, 일개미 = 1
        // 최소한의 병력
        while (hp > 0) {
            if (hp >= 5) {
                int count = hp / 5;
                answer += count;
                hp -= count * 5;
            } else if (hp >= 3) {
                int count = hp / 3;
                answer += count;
                hp -= count * 3;
            } else {
                answer += 1;
                hp -= 1;
            }
        }
        return answer;
    }
}