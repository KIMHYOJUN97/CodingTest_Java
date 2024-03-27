package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.
 * <p>
 * A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
 * ↓                                       ↑
 * A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
 * ↓         ↓                   ↑         ↑
 * A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
 * ↓                                       ↑
 * A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
 * <p>
 * 예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.
 * <p>
 * 1 2 3 4       2 3 4 8       3 4 8 6
 * 5 6 7 8       1 7 7 6       2 7 8 2
 * 9 8 7 6   →   5 6 8 2   →   1 7 6 3
 * 5 4 3 2       9 5 4 3       5 9 5 4
 * <시작>         <회전1>        <회전2>
 * 배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.
 * <p>
 * 첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.
 * 둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.
 * <p>
 * <p>
 * 입력으로 주어진 배열을 R번 회전시킨 결과를 출력한다.
 * <p>
 * <p>
 * 2 ≤ N, M ≤ 300
 * 1 ≤ R ≤ 1,000
 * min(N, M) mod 2 = 0
 * 1 ≤ Aij ≤ 108
 */

/**
 * 예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.
 *
 * 1 2 3 4       2 3 4 8       3 4 8 6
 * 5 6 7 8       1 7 7 6       2 7 8 2
 * 9 8 7 6   →   5 6 8 2   →   1 7 6 3
 * 5 4 3 2       9 5 4 3       5 9 5 4
 *  <시작>         <회전1>        <회전2>
 *      배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.
 */

/**
 *첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.
 * 둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.
 *
 *
 * 입력으로 주어진 배열을 R번 회전시킨 결과를 출력한다.
 *
 *
 * 2 ≤ N, M ≤ 300
 * 1 ≤ R ≤ 1,000
 * min(N, M) mod 2 = 0
 * 1 ≤ Aij ≤ 108
 */

/**
 * 4 4 2
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * <p>
 * 3 4 8 12
 * 2 11 10 16
 * 1 7 6 15
 * 5 9 13 14
 */
public class S1_16926_배열돌리기1 {

    static int[][] graph;
    static int n,m,r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmr = br.readLine().split(" ");
        n = stoi(nmr[0]);
        m = stoi(nmr[1]);
        r = stoi(nmr[2]);
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = stoi(input[j]);
            }
        }

        StringBuilder sb = new StringBuilder();

    }

    static void rotate() {
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
