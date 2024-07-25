class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int count = 0;
        System.out.println(PushWord(A));
        for (int i = 0; i < B.length(); i++) {
            if (A.equals(B)) {
                return count;
            }
            count++;
            A = PushWord(A);
        }
        return -1;
    }
    
    public String PushWord(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(s.length() - 1));
        
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}