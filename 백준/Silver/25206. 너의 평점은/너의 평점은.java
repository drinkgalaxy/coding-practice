import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전공평점 = (학점 * 과목평점)의 총합 / (과목평점의 총합)
        List<List<String>> strList = new ArrayList<>();
        List<String> column;
        double result = 0;
        // 데이터 저장
        for (int i = 0; i < 20; i++) {
            String subject = br.readLine();
            column = new ArrayList<>();
            for (String s : subject.split(" ")) {
                column.add(s);
            }
            strList.add(column);
        }

        // 데이터 다루기
        double majorResult = 0; // 과목평점 * 전공과목의 학점
        double majorAll = 0; // 과목평점의 총합
        for (int i = 0; i < strList.size(); i++) {
            if (!strList.get(i).get(2).equals("P")) {
                double credit = Double.valueOf(strList.get(i).get(1)); // 내 평점
                double gradePoint = 0; // 학점

                if (strList.get(i).get(2).equals("A+")) {
                    gradePoint = 4.5;
                } else if (strList.get(i).get(2).equals("A0")) {
                    gradePoint = 4.0;
                } else if (strList.get(i).get(2).equals("B+")) {
                    gradePoint = 3.5;
                } else if (strList.get(i).get(2).equals("B0")) {
                    gradePoint = 3.0;
                } else if (strList.get(i).get(2).equals("C+")) {
                    gradePoint = 2.5;
                } else if (strList.get(i).get(2).equals("C0")) {
                    gradePoint = 2.0;
                } else if (strList.get(i).get(2).equals("D+")) {
                    gradePoint = 1.5;
                } else if (strList.get(i).get(2).equals("D0")) {
                    gradePoint = 1.0;
                } else if (strList.get(i).get(2).equals("F")) {
                    gradePoint = 0.0;
                }

                majorResult += credit * gradePoint;
                majorAll += credit;

            }
        }
        result = majorResult / majorAll;
        System.out.printf("%.6f", result);
    }
}
