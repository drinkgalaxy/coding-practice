import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        ArrayList<Numbers> list = new ArrayList<>();
        for (int i : numlist) {
            list.add(new Numbers(i, Math.abs(n - i)));
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        int index = 0; 
        for (Numbers numbers : list) {
            answer[index++] = numbers.value;
        }
        return answer;
    }
    
    class Numbers implements Comparable<Numbers> {
        int value;
        int distance;
        
        public Numbers(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
        
        public int compareTo(Numbers other) {
            if (other.distance == this.distance) {
                return Integer.compare(other.value, this.value);
            } else {
                return Integer.compare(this.distance, other.distance);
            }
        }
    }
}