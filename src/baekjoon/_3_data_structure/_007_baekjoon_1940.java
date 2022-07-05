package baekjoon._3_data_structure;

import java.util.Arrays;
import java.util.Scanner;

/*
 *   백준 온라인 저지 1940번 - 주몽의 명령
 */
public class _007_baekjoon_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 재료 개수
        int M = sc.nextInt(); // 갑옷이 완성되는 번호의 합 (재료 2개로 갑옷 가능)
        int[] A = new int[N]; // 재료 배열
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 배열 오름차순으로 정렬
        Arrays.sort(A);

        // 2개의 포인터 설정
        int low_idx = 0; // 낮은 재료 시작 index
        int high_idx = N - 1; // 높은 재료 종료 index

        int cnt = 0;

        while (low_idx < high_idx) { // low_index가 high_index보다 크거나 같아지면 안됨
            if (A[low_idx] + A[high_idx] == M) {
                cnt++;
                low_idx++;
                high_idx--;
            } else if (A[low_idx] + A[high_idx] > M) {
                high_idx--;
            } else if (A[low_idx] + A[high_idx] < M) {
                low_idx++;
            }
        }

        System.out.println(cnt);
    }
}
