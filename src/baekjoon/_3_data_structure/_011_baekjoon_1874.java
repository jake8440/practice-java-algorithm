package baekjoon._3_data_structure;

import java.util.Scanner;
import java.util.Stack;

/*
 *   백준 온라인 저지 1874번 - 스택으로 오름차순 수열 만들기
 */
public class _011_baekjoon_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }

        String answer = "";
        Stack<Integer> stk = new Stack<>();

        int num = 1; // 현재 숫자

        for(int i = 0; i < n; i++){
            if(A[i] >= num){
                while(A[i] >= num){
                    stk.push(num);
                    num++;
                    answer += "+";
                }

                stk.pop();
                answer += "-";
            } else if(A[i] < num){ // 내림차순 일 때에는 값이 같지 않다면 NO 출력 (만드는 것이 불가능하므로)
                int tmp = stk.pop();
                if(tmp > A[i]) {
                    System.out.println("NO");
                    return;
                }
                answer += "-";
            }
        }

        System.out.println(answer);
    }
}
