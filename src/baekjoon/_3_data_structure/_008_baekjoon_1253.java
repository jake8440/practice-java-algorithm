package baekjoon._3_data_structure;

import java.util.Arrays;
import java.util.Scanner;

/*
 *   백준 온라인 저지 1253번 - '좋은 수' 구하기
 */
public class _008_baekjoon_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수의 개수
        int[] A = new int[N]; // 배열
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A); // 오름차순으로 정렬

        int cnt = 0; // 좋은 수 개수

        // 두 포인터 i, j
        // 판별이 되는 수 K가 있다면, K보다 작은 수들만 고려하면 된다.
        for (int k = 0; k < N; k++) {
            long num = A[k];

            int i = 0; // 작은 포인터
            int j = k - 1; // 큰 포인터

            while (i < j) {
                if(A[i] + A[j] == num){
                    cnt++;
                    break;
                } else if(A[i] + A[j] > num){
                    j--;
                } else {
                    i++;
                }
            }
        }

        System.out.println(cnt);
    }
}
