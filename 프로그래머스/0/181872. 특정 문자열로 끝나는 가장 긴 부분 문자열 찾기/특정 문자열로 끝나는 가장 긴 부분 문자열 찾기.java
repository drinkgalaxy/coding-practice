class Solution {
    public String solution(String myString, String pat) {

        int last = myString.lastIndexOf(pat.charAt(pat.length() - 1));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= last; i++) {
            sb.append(myString.charAt(i));
        }
        return sb.toString();
    }
}