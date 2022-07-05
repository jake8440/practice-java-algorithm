package baekjoon._3_data_structure;

import java.util.Scanner;

/*
 *   백준 온라인 저지 10986번 - 나머지 합 구하기
 */
public class _005_baekjoon_10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N + 1]; // 숫자 저장
        int[] S = new int[N + 1]; // 총합 저장, S[i]는 A[1] ~ A[i] 총합
        int[] C = new int[M]; // M으로 나눴을 때 나머지들의 배열

        int tot = 0;

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            S[i] = (S[i - 1] + A[i]) % M;
        }

        // S[j] - S[i-1]이 M으로 나누어 떨어져야 함 : S들의 배열 중 동일한 나머지를 가진 것들의 개수를 구하면 된다
        // S[1] ~ S[N]까지 나머지들의 개수가 같은 것들만 모아서, 그 개수가 2개 이상일 때, 2개를 고르는 횟수만큼이 쌍의 개수다
        for(int i = 1; i< N; i++){
            C[S[i] % M]++;
        }

        // (i, i) 추가
        for(int i= 1; i<= N; i++) tot++;

        // C[i]가 2개 이상일 때, 2개를 고르는 회수 추가
        for(int i = 0; i<M; i++){
            if(C[i] > 1){
                tot += C[i] * (C[i] - 1) / 2;
            }
        }

        System.out.println(tot);
    }
}
