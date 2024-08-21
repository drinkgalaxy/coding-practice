class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for (String s : myString.split("")) {
            if (s.equals("a") || s.equals("A")) {
                sb.append("A");
            } else if (s.equals(" ")) {
                sb.append(" ");
            } else {
                sb.append(s.toLowerCase());
            }
        }
        
        return sb.toString();
    }
}