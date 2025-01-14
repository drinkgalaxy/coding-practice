class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }
        
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) {
            return "-1";
        } else if (sb.toString().startsWith("0")) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}