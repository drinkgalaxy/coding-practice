import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] number1 = {1, 2, 3, 4, 5};
        int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] numbers = new int[3];
        numbers[0] = countAnswer(answers, number1);
        numbers[1] = countAnswer(answers, number2);
        numbers[2] = countAnswer(answers, number3);

        ArrayList<Integer> resultList = new ArrayList<>();
        if (numbers[0] == numbers[1] && numbers[1] > numbers[2]) {
            resultList.add(1);
            resultList.add(2);
        } else if (numbers[0] == numbers[2] && numbers[2] > numbers[1]) {
            resultList.add(1);
            resultList.add(3);
        } else if (numbers[1] == numbers[2] && numbers[2] > numbers[0]) {
            resultList.add(2);
            resultList.add(3);
        } else if (numbers[0] > numbers[1] && numbers[0] > numbers[2]) {
            resultList.add(1);
        } else if (numbers[1] > numbers[0] && numbers[1] > numbers[2]) {
            resultList.add(2);
        } else if (numbers[2] > numbers[0] && numbers[2] > numbers[1]) {
            resultList.add(3);
        } else {
            resultList.add(1);
            resultList.add(2);
            resultList.add(3);
        }
        
        int[] result = new int[resultList.size()];
        int idx = 0;
        for (Integer i : resultList) {
            result[idx++] = i;
        }
        
        return result;
    }
    
    public static int countAnswer(int[] answers, int[] numbers) {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == numbers[i % numbers.length]) {
                count++;
            }
        }
        return count;
    }
}