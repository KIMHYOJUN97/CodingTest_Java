package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class G4_2580_스도쿠 {

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[9][9];
        for (int _i = 0; _i < 9; _i++) {
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                graph[_i][i] = stoi(s[i]);
            }
        }

        dfs(0, 0);
    }

    static void dfs(int x, int y) {
        if (x == 9) {
            dfs(0, y + 1);
            return;
        }

        if (y == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(graph[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (graph[y][x] == 0) {
            // 가능한 걸 다 놔보는 경우의 수
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    graph[y][x] = i;
                    dfs(x + 1, y);
                }
            }
            // 가능한 경우의 수를 다 놓았음에도 안됨
            graph[y][x] = 0;
            return;
        }

        dfs(x + 1, y);
    }

    static boolean check(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (graph[i][x] == value) return false;
            if (graph[y][i] == value) return false;
        }

        int dx = (x / 3) * 3;
        int dy = (y / 3) * 3;
        for (int i = dy; i < dy + 3; i++) {
            for (int j = dx; j < dx + 3; j++) {
                if (graph[i][j] == value) return false;
            }
        }

        return true;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
