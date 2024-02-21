import java.util.*;
import java.io.*;

public class Main {
    static int checkArr[]; // 비밀번호 체크 배열
    static int myArr[]; // 현재 상태 배열
    static int checkSecret; // 몇 개의 문자와 관련된 개수를 충족했는지?
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 문자열 길이

        int Result = 0;
        char A[] = new char[S];
        A = br.readLine().toCharArray(); // 민호가 임의로 만든 DNA 문자열

        checkArr = new int[4]; // 비밀번호 체크 배열
        myArr = new int[4]; // 현재 상태 배열
        checkSecret = 0; // 몇 개의 문자와 관련된 개수를 충족했는지?

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            // checkArr[i] == 0 이라는 뜻은,
            // ACGT 안에 어떤 한 문자열은 조건이 0. 따라서 없어도 괜찮은 문자열이 존재함.
            // 따라서 0을 이미 만족했기 때문에 만족 했다는 의미로 ++
            if (checkArr[i] == 0) {
                checkSecret ++;
            }
        }
        // 초기 P 부분 문자열 처리 부분
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4) {
            Result ++;
        }


        // 슬라이딩 윈도우 처리 부분
        // j -> 윈도우의 맨 왼쪽, i -> 윈도우의 맨 오른쪽
        for (int i = P; i < S; i++) {
            int j = i - P; // 범위를 유지하면서 한 칸씩 가는 효과가 있음.
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                Result ++;
            }
        }

        System.out.println(Result);
        br.close();
    }
    // 새로 들어온 문자 처리 Add 함수
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0] ++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret ++;
                }
                break;
            case 'C':
                myArr[1] ++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret ++;
                }
                break;
            case 'G':
                myArr[2] ++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret ++;
                }
                break;
            case 'T':
                myArr[3] ++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret ++;
                }
                break;
        }
    }
    // 제거되는 문자 처리 Remove 함수
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--; // 이전 부분 문자열의 시작 문자 제외
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--; // 이전 부분 문자열의 시작 문자 제외
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--; // 이전 부분 문자열의 시작 문자 제외
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--; // 이전 부분 문자열의 시작 문자 제외
                }
                myArr[3]--;
                break;
        }
    }
}
