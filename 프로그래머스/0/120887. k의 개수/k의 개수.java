class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int n = i; n <= j; n++) {
            String number = String.valueOf(n);
            for (int a = 0; a < number.length(); a++) {
                if (String.valueOf(number.charAt(a)).equals(String.valueOf(k))) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}