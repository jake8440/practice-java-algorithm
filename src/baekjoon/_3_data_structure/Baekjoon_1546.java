package baekjoon._3_data_structure;

import java.util.Scanner;

/*
 *   백준 온라인 저지 1546번 - 평균 구하기
 */
public class Baekjoon_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        /*
        * new total sum 로직
        * (A/M) * 100 + (B/M) * 100 + (C/M) * 100 = (A + B + C) / M * 100 = sum / M * 100
        * */

        // 반복문으로 sum을 구하는 동시에 최대값 M 구하기
        int M = A[0];
        int sum = 0;
        for(int i = 0; i < N; i++){
            if(A[i] > M) M = A[i];
            sum += A[i];
        }

        double newAv = sum * 100.0 / M / N;
        System.out.println(newAv);
    }
}
