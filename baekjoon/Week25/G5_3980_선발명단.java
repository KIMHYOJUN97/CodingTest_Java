package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_3980_선발명단 {
    static int[][] player;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < n; t++) {
            player = new int[11][11];
            answer = 0;
            visit = new boolean[11];
            for (int i = 0; i < 11; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < 11; j++) {
                    player[i][j] = stoi(s[j]);
                }
            }

            dfs(0, 0);

            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void dfs(int score, int idx) {
        if (idx == 11) {
            answer = Math.max(score, answer);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!visit[i] && player[idx][i] != 0) {
                visit[i] = true;
                dfs(score + player[idx][i], idx + 1);
                visit[i] = false;
            }
        }

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
