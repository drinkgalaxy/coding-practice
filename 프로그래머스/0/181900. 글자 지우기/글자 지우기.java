class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        
        String[] my_arr = my_string.split("");
        for (int i = 0; i < indices.length; i++) {
            my_arr[indices[i]] = "";
        }
        
        for (String s : my_arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}