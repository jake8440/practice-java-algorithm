package baekjoon._3_data_structure;

import java.util.*;

/*
 *   백준 온라인 저지 11003번 - 최솟값 찾기
 */
public class _010_baekjoon_11003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 총 숫자의 개수
        int L = sc.nextInt(); // 슬라이딩 윈도우 크기

        // 덱 설정 : First에 있는 값을 출력하고, 신규 건은 Last로 들어온다
        Deque<Node> A = new LinkedList<Node>();

        // Node를 입력받으면서 제거한다
        for (int i = 0; i < N; i++) {
            int now = sc.nextInt(); // 현재 입력받은 값

            // last의 value가 현재 입력받은 값보다 크다면 제거 (비어있다면 멈춘다)
            while ((!A.isEmpty()) && A.getLast().value > now) {
                A.removeLast();
            }

            // 현재값 추가
            A.addLast(new Node(i, now));

            // 슬라이딩 윈도우에서 벗어난 First 제거
            // 현재의 index : i
            if (A.getFirst().index <= i - L) {
                A.removeFirst();
            }

            // 현재 노드 확인
//            for (Node node : A) {
//                System.out.println("index : " + node.index + ", value : " + node.value);
//            }

            // First 값 출력
            System.out.println(A.getFirst().value);
        }
    }

    // Node 설정
    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
