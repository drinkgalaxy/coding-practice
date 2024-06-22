class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < alphabets.length; i++) {
            s = s.replace(alphabets[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}