class Solution {
    public boolean solution(int x) {
        
        return isH(x) ? true : false;
    }
    
    boolean isH(int x) {
        
        String snum = String.valueOf(x); 
        
        int sum = 0;
        for (String xx : snum.split("")) {
            sum += Integer.parseInt(xx);
        }
        
        return x % sum == 0 ? true : false;
        
        
    }
}