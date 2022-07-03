package baekjoon._3_data_structure;

import java.util.Scanner;

/*
 *   백준 온라인 저지 11720번 - 숫자의 합 구하기
 */
public class Baekjoon_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0; // total 값
        for(int i = 0; i<N; i++){
            sum += cNum[i] - '0'; // String int로 형변환 시 '0', 48만큼 추가되니 빼줘야 함
        }

        System.out.println(sum);
    }
}
