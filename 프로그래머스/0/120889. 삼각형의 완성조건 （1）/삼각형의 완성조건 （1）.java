import java.util.*;
class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int max = sides[2];
        int a = sides[0];
        int b = sides[1];
        return (max < a + b) ? 1 : 2;
    }
}