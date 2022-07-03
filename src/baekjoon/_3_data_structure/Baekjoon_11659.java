package baekjoon._3_data_structure;

import java.util.Scanner;

/*
 *   백준 온라인 저지 11659번 - 구간 합 구하기
 */
public class Baekjoon_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수의 총 개수, 1 ~ 100,000
        int M = sc.nextInt(); // 합을 구해야 하는 횟수(질의 횟수)
        int[] A = new int[N]; // 배열
        int[] S = new int[N + 1]; // 구간 합, 0번째는 0으로 설정
        S[0] = 0; // 초기값 설정

        // 배열 입력
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        // 구간 합 설정
        for(int i=1; i <= N; i++){
            S[i] = S[i-1] + A[i-1];
        }

        for(int i = 0; i < M; i++){
            int startNum = sc.nextInt();
            int endNum = sc.nextInt();

            System.out.println(S[endNum] - S[startNum - 1]);
        }
    }
}
