class Solution {
    public String solution(String code) {
        String ret = "";
        boolean mode = false;
        for (int i = 0; i < code.length(); i++) {
            if (!mode) {
                if (code.charAt(i) != '1') {
                    if (i % 2 == 0) {
                        ret += String.valueOf(code.charAt(i));
                    }
                } else {
                    mode = (!mode);
                }
            } else {
                if (code.charAt(i) != '1') {
                    if (i % 2 != 0) {
                        ret += String.valueOf(code.charAt(i));
                    }
                } else {
                    mode = (!mode);
                }
            }
        }
        
        if (ret.isEmpty()) {
            return "EMPTY";
        } else {
            return ret;
        }
    }
}