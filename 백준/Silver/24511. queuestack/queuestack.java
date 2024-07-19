
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 자료구조 개수

        int[] typeArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 자료구조의 형태 입력받기
        for (int i = 0; i < N; i++) {
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        // 각각의 자료구조가 가질 원소 1개씩 입력받기
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (typeArr[i] == 0) {
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        // 수열 삽입
        while (M --> 0) {
            int changeValue = Integer.parseInt(st.nextToken());

            // 스택일 경우는 데이터가 바뀌지 않아서 아무일도 일어나지 않음
            deque.addFirst(changeValue);
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}