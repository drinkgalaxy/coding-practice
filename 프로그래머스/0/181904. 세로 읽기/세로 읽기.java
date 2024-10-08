class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        String[] save = new String[my_string.length() / m];

        int index = 0;
        for (int i = 0; i < my_string.length(); i = i + m) {
            save[index] = my_string.substring(i, m + i);
            index++;
        }

        for (String s : save) {
            sb.append(s.charAt(c - 1));
        }
    
        return sb.toString();
    }
}