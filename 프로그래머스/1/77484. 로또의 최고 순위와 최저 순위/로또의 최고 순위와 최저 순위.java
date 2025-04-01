class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] arr = new int[46];
        
        for (int i : lottos) {
            arr[i]++;
        }
        
        for (int i : win_nums) {
            arr[i]++;
        }
        
        int max = 0;
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2) {
                min++;
            }
        }
        max = min + arr[0];
        
        return new int[]{score(max), score(min)};
    }
    
    private static int score(int count) {
        if (count == 6) return 1;
        if (count == 5) return 2;
        if (count == 4) return 3;
        if (count == 3) return 4;
        if (count == 2) return 5;
        else return 6;
    }
}