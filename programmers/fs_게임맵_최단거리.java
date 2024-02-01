package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class fs_게임맵_최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int solution(int[][] maps) {
        int answer = 0;

        int[][] visit = new int[maps.length][maps[0].length];

        Queue<Node> q = new LinkedList<>();
        visit[0][0] = 1;

        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && ny >= 0 && ny < maps.length && nx < maps[0].length && maps[ny][nx] != 0 && visit[ny][nx] == 0) {
                    q.add(new Node(nx, ny));
                    visit[ny][nx] = visit[now.y][now.x] + 1;
                }
            }
        }

        answer = visit[maps.length - 1][maps[0].length - 1] == 0 ? -1 : visit[maps.length - 1][maps[0].length - 1];

        return answer;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
