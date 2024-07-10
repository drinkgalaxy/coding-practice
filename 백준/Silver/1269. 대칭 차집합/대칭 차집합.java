
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int elementCountA = Integer.parseInt(st.nextToken()); // A 원소 개수
        int elementCountB = Integer.parseInt(st.nextToken()); // B 원소 개수
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        Set<Integer> temp = new HashSet<>();

        // 데이터 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < elementCountA; i++) {
            int element = Integer.parseInt(st.nextToken());
            A.add(element);
            temp.add(element);

        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < elementCountB; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        // 차집합 구하기
        A.removeAll(B);
        B.removeAll(temp);
        
        System.out.println(A.size() + B.size());
    }
}