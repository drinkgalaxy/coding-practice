import java.util.*;
import java.io.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] numbers = new int[3];
        ArrayList<Integer> result = new ArrayList<>();
        int[] number1 = {1, 2, 3, 4, 5};
        int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        numbers[0] = countAnswer(number1, answers);
        numbers[1] = countAnswer(number2, answers);
        numbers[2] = countAnswer(number3, answers);
        
        if (numbers[0] > numbers[1] && numbers[0] > numbers[2]) {
            result.add(1);
        } else if (numbers[1] > numbers[0] && numbers[1] > numbers[2]) {
            result.add(2);
        } else if (numbers[2] > numbers[0] && numbers[2] > numbers[1]) {
            result.add(3);
        } else if (numbers[0] == numbers[1] && numbers[0] > numbers[2]) {
            result.add(1);
            result.add(2);
        } else if (numbers[1] == numbers[2] && numbers[1] > numbers[0]) {
            result.add(2);
            result.add(3);
        } else if (numbers[2] == numbers[0] && numbers[2] > numbers[1]) {
            result.add(1);
            result.add(3);
        } else {
            result.add(1);
            result.add(2);
            result.add(3);
        }

        return result;
    }
    
    public static int countAnswer(int[] numbers, int[] answers) {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == numbers[i % numbers.length]) {
                count++;
            }
        } 
        return count;
    }
}