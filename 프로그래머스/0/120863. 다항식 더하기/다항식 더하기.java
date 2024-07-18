class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int count = 0;
        int constant = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                if (s.length() > 1) {
                    count += Integer.parseInt(s.replace("x", ""));
                } else {
                    count++;
                }
            } else {
                if (!s.equals("+")) {
                    constant += Integer.parseInt(s);
                }
            }
        }
        
        if (constant > 0) {
            if (count == 1) {
                sb.append("x").append(" + ").append(constant);
            } else if (count == 0) {
                sb.append(constant);
            } else {
                sb.append(count).append("x").append(" + ").append(constant);
            }
        } else {
            if (count == 1) {
                sb.append("x");
            } else if (count == 0) {
                sb.append("");
            } else {
                sb.append(count).append("x");
            }
        }
        
        return sb.toString();
    }
}