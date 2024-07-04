package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간초과
public class _1450_냅색문제_timeover {
    static int answer = 0, n, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = stoi(s[0]);
        c = stoi(s[1]);

        int[] weights = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weights[i] = stoi(s[i]);
        }

        dfs(0, 0, weights);
        System.out.println(answer);
    }

    static void dfs(int depth, int weight, int[] weights) {
        if(depth == n){
            if (weight <= c) {
                answer++;
            }

            return;
        }

        if(weight + weights[depth] <= c){
            dfs(depth + 1, weight + weights[depth], weights);
        }

        dfs(depth + 1, weight, weights);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
