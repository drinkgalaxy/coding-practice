class Solution {
    public String solution(int a, int b) {
        String[] weekArr = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        Integer[] monthArr = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day = 0;
        for (int i = 0; i < a - 1; i++) {
            day += monthArr[i];
        }
        day += b;
        
        int index = (day - 1) % weekArr.length;
        
        return weekArr[index];
    }
}