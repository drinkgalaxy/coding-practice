class Solution {
    boolean solution(String s) {
        int pc = 0;
        int yc = 0;
        
        for (String str : s.split("")) {
            if (str.equals("p") || str.equals("P")) {
                pc++;
            } else if (str.equals("y") || str.equals("Y")) {
                yc++;
            }
        }
        
        if (pc != 0 || yc != 0) {
            return (pc == yc) ? true : false;
        } else {
            return true;
        }
    }
}