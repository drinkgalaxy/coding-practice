import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                // if (!set.contains(i)) {
                //     set.add(i);
                // }
                if (!list.contains(i)) {
                    list.add(i);
                }
                n /= i;
            }
        }
        
        // int[] result = new int[set.size()];
        int[] result = new int[list.size()];
        // int index = 0;
        // for (Integer i : set) {
        //     result[index] = i;
        //     index++;
        // }
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}