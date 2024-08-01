class Solution {
    public int solution(int n, String control) {

        for (String s : control.split("")) {
            if (s.equals("w")) {
                n++;
            } else if (s.equals("s")) {
                n--;
            } else if (s.equals("d")) {
                n += 10;
            } else {
                n -= 10;
            }
        }
        
        return n;
    }
}