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
        
        if (newString.contains(pat)) {
            return 1;
        } else {
            return 0;
        }
    }
}