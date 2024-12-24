import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int i : win_nums) {
            set.add(i);
        }
        
        int yn = 0;
        int zn = 0;
        
        for (int i : lottos) {
            if (set.contains(i)) {
                yn++;
            } else if (i == 0) {
                zn++;
            }
        }
        
        int maxCount = yn + zn;
        int minCount = yn;
        
        return new int[]{getCount(maxCount), getCount(minCount)};
    }
    
    public int getCount(int count) {
        if (count == 6) {
            return 1;
        } else if (count == 5) {
            return 2;
        } else if (count == 4) {
            return 3;
        } else if (count == 3) {
            return 4;
        } else if (count == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}