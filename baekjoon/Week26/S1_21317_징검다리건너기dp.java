package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Integer.MAX_VALUE 주의해서 사용하기.
 * overflow 날 수 있음
 */
public class S1_21317_징검다리건너기dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        Node[] nodes = new Node[30];
        for (int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            nodes[i] = new Node(stoi(s[0]), stoi(s[1]));
        }

        int[][] dp = new int[30][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 5000;
            dp[i][1] = 5000;
        }

        int k = stoi(br.readLine());
        dp[2][0] = nodes[1].small;
        dp[3][0] = Math.min(nodes[1].big, nodes[1].small + nodes[2].big);

        for (int i = 4; i <= n; i++) {
            dp[i][0] = Math.min(dp[i][0], Math.min(dp[i - 1][0] + nodes[i - 1].small, dp[i - 2][0] + nodes[i - 2].big));
            // 한 번도 슈퍼점프를 사용하지 않은 dp에 대해서만 슈퍼점프 사용
            dp[i][1] = Math.min(dp[i][1], dp[i - 3][0] + k);
            dp[i][1] = Math.min(dp[i][1], Math.min(dp[i - 1][1] + nodes[i - 1].small, dp[i - 2][1] + nodes[i - 2].big));
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }

    static class Node {
        int small;
        int big;

        public Node(int small, int big) {
            this.small = small;
            this.big = big;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
