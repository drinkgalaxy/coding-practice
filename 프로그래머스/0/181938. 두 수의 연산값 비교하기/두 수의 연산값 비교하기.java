class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int ab2 = 2 * a * b;
        
        String avalue = String.valueOf(a);
        String bvalue = String.valueOf(b);
        
        String ab = avalue + bvalue;
        int abvalue = Integer.parseInt(ab);
        
        if (abvalue >= ab2) {
            answer = abvalue;
        } else {
            answer = ab2;
        }
        
        return answer;
    }
}