class Solution {
    public boolean solution(int x) {
        int total = 0;
        String.valueOf(x);
        for (String s : String.valueOf(x).split("")) {
            total += Integer.valueOf(s);
        }
        
        return (x % total) == 0 ? true : false;
    }
}