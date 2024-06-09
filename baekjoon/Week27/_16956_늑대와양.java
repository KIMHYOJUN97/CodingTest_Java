package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _16956_늑대와양 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r = stoi(s[0]);
        int c = stoi(s[1]);

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        String[][] map = new String[r][c];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (map[i][j].equals("W")) {
                    q.add(new Node(j, i));
                }
            }
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= c || ny >= r || map[ny][nx].equals("W") || map[ny][nx].equals("D"))
                    continue;
                if (map[ny][nx].equals("S")) {
                    System.out.println(0);
                    return;
                }else if(map[ny][nx].equals(".")){
                    map[ny][nx] = "D";
                }
            }
        }

        System.out.println(1);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
