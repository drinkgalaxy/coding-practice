class Solution {
    public String solution(String my_string, int[] indices) {
        String[] my_arr = my_string.split("");
        
        for (int i : indices) {
            my_arr[i] = "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : my_arr) {
            if (!s.equals("")) {
                sb.append(s);
            }
        }
        
        return sb.toString();
    }
}