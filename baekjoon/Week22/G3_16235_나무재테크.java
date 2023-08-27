package baekjoon.Week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_16235_나무재테크 {

    static int[] dx = {-1,1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,-1,1,-1,1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        int[][] board = new int[n+1][n+1];
        //처음 양분은 모든 칸에 5씩 존재.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = 5;
            }
        }

        int[][] energy = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                energy[i][j] = stoi(st.nextToken());
            }
        }

        //m개의 나무 구입.

        PriorityQueue<Position> treePosition = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int z = stoi(st.nextToken());

            treePosition.add(new Position(x,y,z));
        }

        while (k-- > 0) {
            PriorityQueue<Position> waitQueue = new PriorityQueue<>();
            Queue<Position> feedTree = new LinkedList<>();
            //봄 여러나무가 있으면 어린 나무부터 먹임
            while (!treePosition.isEmpty()) {
                Position now = treePosition.poll();
                if (board[now.r][now.c] >= now.age) {
                    board[now.r][now.c] -= now.age;
                    waitQueue.add(new Position(now.r,now.c,now.age+1));
                } else {
                    feedTree.add(now);
                }
            }

            //여름을 나누어주자 ->바로 양분이 되면 안된다.
            while (!feedTree.isEmpty()) {
                Position now = feedTree.poll();
                board[now.r][now.c] += now.age/2;
            }

            //가을
            while (!waitQueue.isEmpty()) {
                Position now = waitQueue.poll();
                if (now.age % 5 == 0) {
                    for (int i = 0; i < 8; i++) {
                        int nx = now.c + dx[i];
                        int ny = now.r + dy[i];
                        if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                            treePosition.add(new Position(ny, nx, 1));
                        }
                    }
                }

                treePosition.add(now);
            }

            //겨울
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    board[i][j] += energy[i][j];
                }
            }
        }

        System.out.println(treePosition.size());

    }

    static class Position implements Comparable<Position>{
        int r;
        int c;
        int age;

        public Position(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Position o) {
            return age - o.age;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
