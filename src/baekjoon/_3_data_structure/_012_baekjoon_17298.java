package baekjoon._3_data_structure;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 *   백준 온라인 저지 17298번 - 오큰수 구하기
 */
public class _012_baekjoon_17298 {
    public static void main(String[] args) {


        // 반복문으로 찾다간 시간제한에 걸림
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N]; // 숫자의 수열

        Stack<Integer> stk = new Stack<>(); // index를 저장하기 위한 stack
        int[] answer = new int[N]; // 리턴 값을 저장할 배열

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        long startTime = System.currentTimeMillis();
        stk.push(0);

        for(int i = 1; i < N; i++){
            while(!stk.isEmpty() && A[stk.peek()] < A[i]){
                answer[stk.pop()] = A[i];
            }
            stk.push(i);
        } // for문 종료

        // for문 종료 후 스택에 들어가있는 모든 index들에 -1 부여
        while(!stk.isEmpty()){
            answer[stk.pop()] = -1;
        }

        long endTime = System.currentTimeMillis();

        System.out.println(Arrays.toString(answer));
        System.out.println("수행시간 : " + (endTime - startTime) + "ms");
    }
}
