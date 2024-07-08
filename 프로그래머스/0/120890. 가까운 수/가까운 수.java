import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int[] count = new int[array.length];
        int[] saveArray = new int[array.length];
        Arrays.sort(array);
        int id = 0;
        for (Integer i : array) {
            saveArray[id] = i;
            id++;
        }
        
        for (int i = 0; i < array.length; i++) {
            while (saveArray[i] != n) {
                if (saveArray[i] < n) {
                    count[i]++;
                    saveArray[i]++;
                } else if (saveArray[i] > n) {
                    count[i]++;
                    saveArray[i]--;
                } else {
                    break;
                }
            }
        }
        int min = 100;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] < min) {
                min = count[i];
                index = i;
            }
        }
        return array[index];
    }
}