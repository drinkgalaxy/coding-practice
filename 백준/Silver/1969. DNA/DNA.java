import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt(); // DNA의 개수
        int M = scanner.nextInt(); // DNA의 길이
        String[] dnaList = new String[N];

        for (int i = 0; i < N; i++) {
            dnaList[i] = scanner.next();
        }

        StringBuilder consensusDNA = new StringBuilder();
        int totalHammingDistance = 0;

        // 각 위치별로 최적의 문자를 선택
        for (int i = 0; i < M; i++) {
            int[] count = new int[4]; // A, C, G, T의 개수

            for (String dna : dnaList) {
                char nucleotide = dna.charAt(i);
                switch (nucleotide) {
                    case 'A': count[0]++; break;
                    case 'C': count[1]++; break;
                    case 'G': count[2]++; break;
                    case 'T': count[3]++; break;
                }
            }

            // 가장 많이 등장하는 뉴클레오타이드 찾기
            int maxCount = 0;
            char bestNucleotide = 'A';
            char[] nucleotides = {'A', 'C', 'G', 'T'};
            
            for (int j = 0; j < 4; j++) {
                if (count[j] > maxCount || (count[j] == maxCount && nucleotides[j] < bestNucleotide)) {
                    maxCount = count[j];
                    bestNucleotide = nucleotides[j];
                }
            }

            consensusDNA.append(bestNucleotide);
            totalHammingDistance += (N - maxCount);
        }

        System.out.println(consensusDNA.toString());
        System.out.println(totalHammingDistance);
    }
}
