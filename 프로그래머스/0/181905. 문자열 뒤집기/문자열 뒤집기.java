class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        StringBuilder newsb = new StringBuilder(my_string.substring(s, e + 1)).reverse();
        for (int i = 0; i < newsb.length(); i++) {
            sb.setCharAt(i+s, newsb.charAt(i));
        }
        return sb.toString();
    }
}