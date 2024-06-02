package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_18429_근손실 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);
        s = br.readLine().split(
                " "
        );
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = stoi(s[i]);
        }

        boolean[] visit = new boolean[n];
        backtracking(weights, 0, 500, k, visit);
        System.out.println(answer);
    }

    static void backtracking(int[] weights, int idx, int sum, int k, boolean[] visit) {
        if (idx == weights.length) {
            answer++;
            return;
        }

        for (int i = 0; i < weights.length; i++) {
            if (!visit[i] && sum + weights[i] - k >= 500) {
                visit[i] = true;
                backtracking(weights, idx + 1, sum + weights[i] - k, k, visit);
                visit[i] = false;
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

