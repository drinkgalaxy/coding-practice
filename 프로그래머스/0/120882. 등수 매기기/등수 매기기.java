import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        ArrayList<Student> list = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            list.add(new Student(i, (score[i][0] + score[i][1])/2.0));
        }
        
        Collections.sort(list);
        
        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i).meanScore < list.get(i - 1).meanScore) {
                rank = i + 1;
            }
            list.get(i).setRank(rank);
        }
        
        // 원래 순서대로 등수를 저장
        for (Student student : list) {
            answer[student.index] = student.rank;
        }
        
        return answer;
    }
    
    class Student implements Comparable<Student>{
        int index;
        double meanScore;
        int rank;
        
        public Student(int index, double meanScore) {
            this.index = index;
            this.meanScore = meanScore;
        }
        
        public void setRank(int rank) {
            this.rank = rank;
        }
        
        @Override
        public int compareTo(Student other) {
            return Double.compare(other.meanScore, this.meanScore);
        }
    }
}