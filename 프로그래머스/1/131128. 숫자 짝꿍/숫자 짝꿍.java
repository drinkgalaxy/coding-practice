class Solution {
    public String solution(String X, String Y) {
        
        int[] Xcount = new int[10];
        int[] Ycount = new int[10];
        
        for (String x : X.split("")) {
            Xcount[Integer.parseInt(x)]++;
        }
        
        for (String y : Y.split("")) {
            Ycount[Integer.parseInt(y)]++;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(Xcount[i], Ycount[i]); 
        
            for (int j = 0; j < count; j++) {
                result.append(i);
            }
        }
        
        if (result.length() == 0) {
            return "-1";
        }
        
        if (result.toString().startsWith("0")) {
            return "0";
        }
        
        return result.toString();
    }
}