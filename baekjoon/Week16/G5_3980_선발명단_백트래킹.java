package baekjoon.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_3980_선발명단_백트래킹 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = stoi(br.readLine());
        for (int c = 0; c < C; c++) {
            //선수별 포지션 능력치
            ans = 0;
            int[][] board = new int[11][11];
            boolean[] visited = new boolean[11];
            for (int i = 0; i < 11; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < 11; j++) {
                    board[i][j] = stoi(s[j]);
                }
            }

            dfs(board,0,0,visited);
            System.out.println(ans);
        }
    }

    /**
     * 한 포지션당 한 명의 사람만이 들어갈 수 있다.
     * visited 포지션에 사람이 뽑혔는지를 확인한다.
     * @param board : board
     * @param cnt: 현재 뽑는 사람
     * @param result : 능력치의 총 합
     * @param visit : 뽑았는지 보기 위함
     */
    static void dfs(int[][] board,int cnt,int result,boolean[] visit) {
        if (cnt == 11) {
            ans = Math.max(ans, result);
            return;
        }

        //board[cnt][i] ->cnt번 사람의 i번째 포지션에 대한 능력치
        for (int i = 0; i < 11; i++) {
            if (!visit[i] && board[cnt][i] != 0) {
                visit[i] = true;
                dfs(board, cnt + 1, result + board[cnt][i], visit);
                visit[i] = false;
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
