package baekjoon.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S1_2178_미로탐색_그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        List<String> b = new ArrayList<>();
        for(int i=0;i<n;i++) {
            b.add(br.readLine());
        }
        int[][] board = new int[b.size()+1][b.get(0).length()+1];
        for (int i = 1; i <= b.size(); i++) {
            for (int j = 1; j <= b.get(0).length(); j++) {
                board[i][j] = stoi(String.valueOf(b.get(i-1).charAt(j-1)));
            }
        }
        boolean[][] visited = new boolean[b.size()+1][b.get(0).length()+1];
        visited[1][1] = true;

        Queue<int[]> queue = new LinkedList<>();
        int[] start = {1,1};
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=1 && ny>=1 && ny<=b.size() && nx<=b.get(0).length() && board[ny][nx]==1 && visited[ny][nx]==false){
                    board[ny][nx] = board[now[1]][now[0]]+1;
                    visited[ny][nx] = true;
                    int[] nxt = {nx,ny};
                    queue.add(nxt);
                }
            }
        }
        System.out.println(board[n][m]);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
