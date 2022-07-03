package baekjoon._10_combination;

/*
 *   백준 온라인 저지 11050번 - 이항계수 구하기 1
 *   난이도 브론즈 1
 */
import java.util.Scanner;

public class Baekjoon_11050 {
    /* 컴비네이션 조합식을 사용한다
     * D[i][j] = D[i-1][j] + D[i-1][j-1]
     * D[i][0] = 1
     * D[i][i] = 1
     * D[i][1] = i
     */
    static int N, K;
    static int[][] D;

    private int solution(int n, int k) {
        int ret = 0;
        D = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            D[i][0] = 1;
            D[i][i] = 1;
            D[i][1] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        ret = D[n][k];

        return ret;
    }

    public static void main(String[] args) {
        Baekjoon_11050 sol = new Baekjoon_11050();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("N 값을 입력하시오 : ");
            N = sc.nextInt();
            if (N <= 0) {
                System.out.println("잘못된 값을 입력하였습니다. N은 0보다 큰 값을 입력하세요.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("K 값을 입력하시오 : ");
            K = sc.nextInt();
            if (N < K) {
                System.out.println("잘못된 값을 입력하였습니다. K는 N보다 큰 값을 입력하세요.");
            } else {
                break;
            }
        }

        int ret = sol.solution(N, K);

        System.out.println("Answer : " + ret);
    }
}
