package baekjoon._3_data_structure;

import java.util.Scanner;

/*
 *   백준 온라인 저지 12891번 - DNA 비밀번호
 */
public class _009_baekjoon_12891 {
    // A, C, G, T로 이루어진 DNA 문자열
    static int[] myArr; // 현재 내 Array의 A, C, G, T Count
    static int[] chkArr; // 비밀번호로 사용 가능한 A, C, G, T Count
    static int chkCnt; // 각 A, C, G, T가 비밀번호로 유효한지 체크

    public static void main(String[] args) {
        myArr = new int[4];
        chkArr = new int[4];
        chkCnt = 0;

        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // DNA 문자열의 길이
        int P = sc.nextInt(); // 비밀번호 문자열 길이
        int cnt = 0;

        String dnaStr = sc.next();
        char[] A = dnaStr.toCharArray(); // DNA 문자열


        // 비밀번호 횟수 입력 받음
        for (int i = 0; i < 4; i++) {
            chkArr[i] = sc.nextInt();
            if (chkArr[i] == 0) chkCnt++; // 0이면 검사할 필요 없으니 미리 + 해준다
        }

        // 최초의 부분 문자열
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if(chkCnt == 4) cnt++; // 최초의 문자열이 조건 만족 시 cnt ++

        // 슬라이딩 윈도우 처리
        for(int i = P; i < S; i++){
            Remove(A[i - P]); // 맨 처음 수 제거
            Add(A[i]); // 가장 위에 수 추가

            if(chkCnt == 4) cnt++;
        }

        System.out.println(cnt);
    }

    // 문자 c 입력 시 myArr에 추가하는 동시에 조건을 만족하는지 확인
    public static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == chkArr[0]) chkCnt++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == chkArr[1]) chkCnt++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == chkArr[2]) chkCnt++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == chkArr[3]) chkCnt++;
                break;
        }
    }

    // 문자 c 제거 시 myArr에 빼는 동시에 조건 불만족 시 Count 제거
    public static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == chkArr[0]) chkCnt--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == chkArr[1]) chkCnt--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == chkArr[2]) chkCnt--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == chkArr[3]) chkCnt--;
                myArr[3]--;
                break;
        }
    }
}
