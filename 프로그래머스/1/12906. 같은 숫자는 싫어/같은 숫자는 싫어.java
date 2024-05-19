import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1) {
                if (arr[i] != arr[i+1]) {
                queue.add(arr[i]);
           } 
         } else {
                queue.add(arr[i]);
            }
        }
        int time = queue.size();
        int[] result = new int[time];
        for (int i = 0; i < time; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}