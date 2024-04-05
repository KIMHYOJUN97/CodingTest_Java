package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 * <p>
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 * <p>
 * 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 * <p>
 * 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 * <p>
 * 8
 * <p>
 * 92
 */
public class G5_9663_NQueen {
    static boolean[] visit;
    static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (check(idx, i)) {
                    dfs(idx + 1);
                }
                visit[i] = false;
            }
        }
    }

    static boolean check(int idx, int x) {
        for (int i = 1; i <= idx; i++) {
            int minus = x - i;
            int plus = x + i;
            if (minus >= 0 && plus < n) {
                if (visit[minus] || visit[plus]) return false;
            }
        }
        return true;
    }
}
