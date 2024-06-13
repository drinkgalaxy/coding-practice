class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // 배열 정렬하기
        Arrays.sort(seats);
        Arrays.sort(students);

        // 그리디로 각 학생을 자리에 배정하기
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            while (students[i] != seats[i]) {
                if (students[i] < seats[i]) {
                    students[i]++;
                    count++;
                } else if (students[i] > seats[i]) {
                    students[i]--;
                    count++;
                }
            }
        }
        return count;
    }
}
