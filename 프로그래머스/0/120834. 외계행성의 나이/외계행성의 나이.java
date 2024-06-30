class Solution {
    public String solution(int age) {
        String[] voca = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        StringBuilder sb = new StringBuilder();
        
        String stringAge = String.valueOf(age);
        for (String s : stringAge.split("")) {
            sb.append(voca[Integer.valueOf(s)]);
        }
        return sb.toString();
    }
}