package baekjoon._3_data_structure;

import java.util.Scanner;

/*
 *   백준 온라인 저지 2018번 - 연속된 자연수의 합 구하기
 */
public class _006_baekjoon_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1; // 총 count 횟수, end_index가 N이 되는 경우에는 무조껀 포함이므로, 1로 초기화
        int sum = 1; // 연속된 자연수의 총합, 1부터 시작

        // 2개의 포인터들 설정
        int start_index = 1; // 시작 좌표
        int end_index = 1; // 끝 좌표

        while (end_index != N) { // N에 도달하면 끝
            if (sum == N) { // 총합이 N이 된다면 end_index 추가
                count++;
                end_index++;
                sum += end_index; // 총합에 end_index 추가
            } else if (sum < N) { // 총합이 N보다 작다면, 다음 연속된 자연수 추가이므로 end_index 추가
                end_index++;
                sum += end_index;
            } else if (sum > N) { // 총합이 N보다 크다면, 연속된 자연수의 첫번째 수 제거
                sum -= start_index;
                start_index++;
            }
        }

        System.out.println(count);
    }
}
