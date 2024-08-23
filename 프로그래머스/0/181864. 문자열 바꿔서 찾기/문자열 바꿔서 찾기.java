class Solution {
    public int solution(String myString, String pat) {
        String[] arr = myString.split("");
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("A")) {
                arr[i] = "B";
            } else {
                arr[i] = "A";
            }
        }
        
        String newString = "";
        for (String s : arr) {
            newString += s;
        }
        
        for (int i = 0; i < newString.length(); i++) {
            if (newString.substring(i).contains(pat)) {
                return 1;
            }
        }
        return 0;
    }
}