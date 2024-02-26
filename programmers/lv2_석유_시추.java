package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// 효율성 체크하기
public class lv2_석유_시추 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
    }

    private static int solution(int[][] land) {
        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            boolean[][] visit = new boolean[land.length][land[0].length];
            List<Integer> ansList = new ArrayList<>();
            int ans = 0;
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1 && visit[j][i] == false) ansList.add(bfs(land, visit, i, j));
            }
            for (Integer integer : ansList) {
                ans += integer;
            }

            answer = Math.max(answer, ans);
        }

        return answer;
    }

    public static int bfs(int[][] land, boolean[][] visit, int x, int y) {
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (!visit[now.y][now.x]) {
                cnt++;
                visit[now.y][now.x] = true;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny >= 0 && nx >= 0 && nx < land[0].length && ny < land.length && land[ny][nx] == 1 && visit[ny][nx] == false) {
                    visit[ny][nx] = true;
                    cnt++;
                    q.add(new Node(nx, ny));
                }
            }
        }

        return cnt;

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
