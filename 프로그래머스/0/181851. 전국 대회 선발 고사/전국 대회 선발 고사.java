import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Student> list = new ArrayList<>();
        
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                list.add(new Student(i, rank[i]));
            }
        }
        
        Collections.sort(list);
        
        int a = list.get(0).number;
        int b = list.get(1).number;
        int c = list.get(2).number;
        
        return 10000 * a + 100 * b + c;
    }
    
    public class Student implements Comparable<Student>{
        int number;
        int rank;
        
        public Student(int number, int rank) {
            this.number = number;
            this.rank = rank;
        }
        
        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.rank, other.rank);
        }
    }
}