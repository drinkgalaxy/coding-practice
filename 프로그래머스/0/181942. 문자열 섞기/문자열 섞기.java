class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[str1.length() + str2.length()];
        
        int index1 = 0;
        for (String s : str1.split("")) {
            arr[index1] = s;
            index1 += 2;
        }
        
        int index2 = 1;
        for (String s : str2.split("")) {
            arr[index2] = s;
            index2 += 2;
        }
        
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}