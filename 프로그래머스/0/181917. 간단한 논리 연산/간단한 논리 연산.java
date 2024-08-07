class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {

        if (function(x1, x2)) {
            if (function(x3, x4)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean function(boolean a, boolean b) {
        boolean result = false;
        if (a) {
            result = true;
        } else {
            if (b) {
                result = true;
            }
        }
        return result;
    }
}