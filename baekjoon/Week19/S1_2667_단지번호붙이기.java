package baekjoon.Week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_2667_단지번호붙이기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] visit = new boolean[n][n];
        int[][] board = new int[n][n];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < inputs.length; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && visit[i][j] == false) {
                    visit[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    int cnt = 1;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int ny = dy[d] + now[0];
                            int nx = dx[d] + now[1];
                            if (ny >= 0 && nx >= 0 && ny < n && nx < n && board[ny][nx] == 1 && visit[ny][nx] == false) {
                                visit[ny][nx] = true;
                                cnt++;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    ans.add(cnt);
                }
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + "\n");
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i) + "\n");
        }

        System.out.println(sb.toString());
    }
}
