class Solution {
    public int solution(int[] array) {
        int count = 0;
        for (Integer i : array) {
            String number = String.valueOf(i);
            for (String s : number.split("")) {
                if (s.equals("7")) {
                    count++;
                }
            }
        }
        return count;
    }
}