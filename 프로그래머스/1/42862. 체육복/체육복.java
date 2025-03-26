class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // student 배열 초기화하고 상태 저장
        int[] student = new int[n];
        for (int i = 0; i < student.length; i++) {
            student[i] = 1;
        }
        for (int i : lost) {
            student[i-1] -= 1;
        }
        for (int i : reserve) {
            student[i-1] += 1;
        }
        
        // 배열 돌면서 2인 애들 체크하고 주변에 0인 애 있으면 나눠주기
        for (int i = 0; i < student.length; i++) {
            if (student[i] == 2) {
                if (i-1 >= 0 && student[i-1] == 0) {
                    student[i-1]++;
                    student[i]--;
                } else if (i+1 < student.length && student[i+1] == 0) {
                    student[i+1]++;
                    student[i]--;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] >= 1) {
                count++;
            }
        }
        
        return count;
    }
}