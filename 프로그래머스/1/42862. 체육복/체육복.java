class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        for (int i = 0; i < student.length; i++) {
            student[i] = 1;
        }
        
        // lost check
        for (int i = 0; i < lost.length; i++) {
            student[lost[i]-1]--;
        }
        
        // reserve check
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i]-1]++;
        }
        
        // student를 돌면서 해당 값이 2 이면 왼쪽 오른쪽 값이 0일 때 빌려주기
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
        
        // 최종적으로 체육복을 가지고 있는 student 수 리턴
        int answer = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}