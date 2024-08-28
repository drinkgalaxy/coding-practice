class Solution {
    public String solution(String n_str) {
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for (String s : n_str.split("")) {
            if (s.equals("0")) {
                count++;
            } else {
                break;
            }
        }
        
        for (int i = count; i < n_str.length(); i++) {
            sb.append(n_str.charAt(i));
        }
        
        return sb.toString();
    }
}