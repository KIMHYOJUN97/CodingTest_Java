package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class G5_15686_치킨배달 {

    static boolean[] visited;
    static int n, m, answer = Integer.MAX_VALUE;
    static List<Node> chicken, home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = stoi(s[0]);
        m = stoi(s[1]);

        int[][] arr = new int[n][n];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = stoi(s[j]);
                if (arr[i][j] == 2) chicken.add(new Node(j, i));
                else if (arr[i][j] == 1) home.add(new Node(j, i));
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int cnt) {

        if (cnt == m) {
            int ans = 0;
            for (Node node : home) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i]) {
                        min = Math.min(min, Math.abs(node.x - chicken.get(i).x) + Math.abs(node.y - chicken.get(i).y));
                    }
                }
                ans += min;
            }
            answer = Math.min(answer, ans);
            return;
        }

        for (int i = idx; i < visited.length; i++) {
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
