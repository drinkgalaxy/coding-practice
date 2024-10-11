class Solution {
    public int[] solution(String s) {
        int totalCount = 0;
        int count = 0;
        
        while (s.length() > 1) {
            for (String IsZero : s.split("")) {
                if (IsZero.equals("0")) {
                    count++;
                }
            }
            s = s.replace("0", "");
            s = String.valueOf(Integer.toBinaryString(s.length()));
            totalCount++;
        }
        
        int[] answer = {totalCount, count};
        return answer;
    }
}