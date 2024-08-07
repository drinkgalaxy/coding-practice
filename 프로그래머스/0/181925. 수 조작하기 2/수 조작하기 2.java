class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numLog.length; i++) {
            if (i > 0) {
                if (numLog[i - 1] == (numLog[i] - 1)) {
                    sb.append("w");
                } else if (numLog[i - 1] == (numLog[i] + 1)) {
                    sb.append("s");
                } else if (numLog[i - 1] == (numLog[i] - 10)) {
                    sb.append("d");
                } else {
                    sb.append("a");
                }
            }
        }
        return sb.toString();
    }
}