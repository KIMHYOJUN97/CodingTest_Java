package baekjoon.Week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 자신보다 큰 물고기가 있는 칸은 지나갈 수 없음
 * 같은 칸의 물고기는 먹을 수는 없지만 지나갈 수는 있음
 * 먹을 수 있는 물고기가 없으면 엄마 상어 부르기
 * 먹을수있는 가까운 물고기가 많다면 우선순위: 위쪽, 왼쪽
 * 자신의 크기와 같은 수의 물고기를 먹을 때 마다 몸무게 증가
 */
public class G3_16236_아기상어 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visit;
    static int n;
    static int sharkSize = 2;
    static int eat = 0;
    static int answer = 0;
    static Position now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        board = new int[n][n];
        visit = new boolean[n][n];
        now = null;
        /**
         * 모든 공간이 0일 때 고려
         */
        PriorityQueue<Position> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = stoi(st.nextToken());
                if(board[i][j]==9) now = new Position(j, i, 0);
            }
        }


    }

    /**
     * 모든 공간에 내가 먹을 수 있는 물고기가 있는지 체크
     * 크기가 큰 곳은 못간다는 조건을 걸어줘야 함.
     */
    static Position checkSize() {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.add(new Position(-1, -1, 100));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] < sharkSize)pq.add(new Position(j,i,Math.abs(now.x-j)+Math.abs(now.y-i)));
            }
        }
        return pq.poll();
    }

    static void moving(Position position) {
        //잡아먹을 게 없을 때
        if(position.dis == 100)return;
        eat++;
        if (eat == sharkSize){
            eat = 0;
            sharkSize++;
        }


    }

    static class Position implements Comparable<Position>{
        int x;
        int y;
        int dis;

        public Position(int x,int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Position o) {
            return dis - o.dis;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
