package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * System.exit(0)은 return에 영향을 끼치지 못하는 가? -> 가능하다
 * visited를 통해 dfs가 이전으로 회귀해서 다시 방문하는 경우를 방지하자.
 */
public class S1_22869_징검다리건너기 {
    static int[] arr;
    static boolean[] dp;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = stoi(s[0]);
        k = stoi(s[1]);
        arr = new int[n];
        dp = new boolean[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(s[i]);
        }

        dfs(0);
        System.out.println("NO");
    }

    static void dfs(int idx) {
        if (idx == n - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int i = idx + 1; i < n; i++) {
            if(!dp[i]){
                if ((i - idx) * (1 + Math.abs(arr[i] - arr[idx])) <= k) {
                    dfs(i);
                    dp[idx] = true;
                }
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
