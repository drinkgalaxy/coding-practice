class Solution {
    public int solution(int num, int k) {
        String[] arr = new String[String.valueOf(num).length()];
        int index = 0;
        for (String s : String.valueOf(num).split("")) {
            arr[index] = s;
            index++;
        }
        
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(String.valueOf(k))) {
                answer = i + 1;
                return answer;
            } 
        }
        return -1;
    }
}