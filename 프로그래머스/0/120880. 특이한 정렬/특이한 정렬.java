import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] saveIndex = new int[numlist.length];
        ArrayList<Data> list = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            list.add(new Data(Math.abs(numlist[i] - n), numlist[i]));
        }
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            saveIndex[i] = list.get(i).originValue;
        }
        
        return saveIndex;
    }
    
    public class Data implements Comparable<Data> {
        int value;
        int originValue;
        
        public Data(int value, int originValue) {
            this.value = value;
            this.originValue = originValue;
        }
        
        @Override
        public int compareTo(Data other) {
        if (this.value == other.value) {
            return Integer.compare(other.originValue, this.originValue);
        } else {
            return Integer.compare(this.value, other.value);
            }
        }
    }
}