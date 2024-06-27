package programmers.com;

import java.util.LinkedList;
import java.util.Queue;

public class lv2_미로탈출 {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(String[] maps) {
            int answer = 0;
            int[][] visited = new int[maps.length][maps[0].length()];
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            Node goal = null, target = null, start = null;

            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[0].length(); j++) {
                    if (maps[i].charAt(j) == 'S') {
                        start = new Node(j, i);
                    }
                    if (maps[i].charAt(j) == 'L') {
                        target = new Node(j, i);
                    }

                    if (maps[i].charAt(j) == 'E') {
                        goal = new Node(j, i);
                    }
                }
            }

            // 레버로 가는 길 중 최단거리 구한 후, EXIT으로 가야 함
            Queue<Node> q = new LinkedList<>();
            q.add(start);
            int cnt = 0;
            while (!q.isEmpty()) {
                Node now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx >=0 && ny >=0 && nx < maps[0].length() && ny < maps.length){
                        if(maps[ny].charAt(nx) != 'X' && visited[ny][nx] == 0){
                            visited[ny][nx] = visited[now.y][now.x] + 1;
                            if(nx == target.x && ny == target.y){
                                cnt = visited[ny][nx];
                            }
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }

            if(cnt == 0) return -1;

            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    if(visited[i][j] > cnt){
                        visited[i][j] = 0;
                    }
                }
            }

            q.add(target);
            while (!q.isEmpty()) {
                Node now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < maps[0].length() && ny < maps.length) {
                        if (maps[ny].charAt(nx) != 'X' && visited[ny][nx] == 0) {
                            visited[ny][nx] = visited[now.y][now.x] + 1;
                            if (nx == goal.x && ny == goal.y) {
                                return visited[ny][nx];
                            }
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }

            return answer;
        }
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
