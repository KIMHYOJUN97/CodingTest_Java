package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_19949_영재의시험 {
    static int[] visit, answers;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answers = new int[10];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 10; i++) {
            answers[i] = stoi(s[i]);
        }

        visit = new int[11];
        int[] result = new int[10];
        dfs(0, result);
        System.out.println(answer);
    }

    static void dfs(int idx, int[] result) {
        if (idx == 10) {
            int count = 0;
            for (int i = 0; i < result.length; i++) {
                if (result[i] == answers[i]) count++;
            }
            if (count >= 5) answer++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i] < 2) {
                visit[i]++;
                result[idx] = i + 1;
                dfs(idx + 1, result);
                visit[i]--;
            }else{
                visit[i] = 0;
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
