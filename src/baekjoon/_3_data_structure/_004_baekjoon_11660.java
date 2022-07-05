package baekjoon._3_data_structure;

import java.util.Scanner;

/*
 *   백준 온라인 저지 11660번 - 구간 합 구하기 2
 */
public class _004_baekjoon_11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 배열 크기
        int M = sc.nextInt(); // 총 횟수

        int[][] A = new int[N + 1][N + 1]; // A는 배열, N+1 X N+1 크기로 선언, 0번째 열과 행에는 모두 0 입력
        int[][] D = new int[N + 1][N + 1]; // D[x][y] : A[0][0] ~ A[x][y]까지의 합

        // 배열 설정(A)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 배열 설정(D)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + A[i][j];
            }
        }

        // M번 반복
        for (int i = 0; i < M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int temp = D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1];
            System.out.println(temp);
        }
    }
}
