class Solution {
    public int solution(String my_string, String target) {
        for (int i = 0; i < my_string.length(); i++) {
            String new_string = my_string.substring(i);
            if (new_string.contains(target)) {
                return 1;
            }
        }
        return 0;
    }
}