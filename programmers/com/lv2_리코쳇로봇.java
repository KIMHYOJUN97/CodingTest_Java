package programmers.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 리코쳇 로봇이라는 보드게임이 있습니다.
 * <p>
 * 이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.
 * <p>
 * 이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.
 * <p>
 * 다음은 보드게임판을 나타낸 예시입니다.
 * <p>
 * ...D..R
 * .D.G...
 * ....D.D
 * D....D.
 * ..D...
 * <p>
 * 여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
 * 위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며, 이것이 최소 움직임 중 하나입니다.
 * <p>
 * 게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.
 */
public class lv2_리코쳇로봇 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D..."};
        System.out.println(solution(board));
    }

    static int solution(String[] board) {
        // robot position
        Node robot = null;
        Node goal = null;
        int[][] visited = new int[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            String[] s = board[i].split("");
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("R")) robot = new Node(j, i);
                if (s[j].equals("G")) {
                    goal = new Node(j, i);
                    visited[j][i] = -1;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();

        q.add(robot);
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == goal.x && now.y == goal.y) return visited[now.x][now.y];
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                while (nx >= 0 && ny >= 0 && nx < board[0].length() && ny < board.length && board[ny].charAt(nx) != 'D') {
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                }

                nx = nx - dx[i];
                ny -= dy[i];
                if (ny == goal.y && nx == goal.x) {
                    visited[ny][nx] = visited[now.y][now.x] + 1;
                    return visited[ny][nx];
                } else {
                    visited[ny][nx] = visited[now.y][now.x] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }

        return visited[goal.y][goal.x];
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
