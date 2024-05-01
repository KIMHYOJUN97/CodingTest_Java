package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_13549_숨바꼭질3 {
    static int n, k,min = Integer.MAX_VALUE;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = stoi(s[0]);
        k = stoi(s[1]);

        visited = new boolean[100001];

        bfs(n, 0);
        System.out.println(min);

    }

    static void bfs(int now, int cnt) {
        if (now == k) {
            min = Math.min(min, cnt);
            return;
        }

        if (now * 2 <= 100000 && !visited[now * 2]) {
            visited[now*2] = true;
            bfs(now * 2, cnt + 1);
            visited[now*2] = false;
        }

        if (now + 1 <= 100000 && !visited[now + 1]) {
            visited[now+1] = true;
            bfs(now + 1, cnt + 1);
            visited[now+1] = false;
        }

        if (now - 1 >= 0 && !visited[now - 1]) {
            visited[now-1] = true;
            bfs(now - 1, cnt + 1);
            visited[now-1] = false;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
