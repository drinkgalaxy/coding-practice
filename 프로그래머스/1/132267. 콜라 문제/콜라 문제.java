class Solution {
    public int solution(int a, int b, int n) {
        int totalCola = 0;
        int currentBottels = n;
        while (currentBottels >= a) {
            // 현재 가진 빈 병으로 교환할 수 있는 콜라의 수
            int exchangedCola = (currentBottels / a) * b;
            totalCola += exchangedCola;
            // 현재 가진 빈 병 수 갱신
            currentBottels = (currentBottels % a) + exchangedCola;
        }
        
        return totalCola;
    }
}