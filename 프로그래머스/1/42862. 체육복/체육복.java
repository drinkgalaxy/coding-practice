class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 1. 새로운 student 배열을 만들고 lost, reserve의 정보를 각각 반영
        // lost면 -1, reserve면 1
        int[] student = new int[n+2];
        for (int l : lost) {
            student[l]--;
        }
        for (int r : reserve) {
            student[r]++;
        }
        // 2. 배열의 값이 1인 인덱스를 보면서 앞뒤 인덱스의 배열의 값이 -1이면(lost 학생이면)
        // 빌려주기 ++,--
        for (int i = 1; i <= n; i++) {
            if (student[i] == 1) {
                if (student[i-1] == -1) {
                    student[i-1]++;
                    student[i]--;
                } else if (student[i+1] == -1) {
                    student[i+1]++;
                    student[i]--;
                }
            }
        }
        // 3. 인덱스의 배열의 값이 0 이상인 student 배열 개수 세기
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}