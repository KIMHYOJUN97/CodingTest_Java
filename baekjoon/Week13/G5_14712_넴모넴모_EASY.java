package baekjoon.Week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_14712_넴모넴모_EASY {
    static int n, m, ans = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = stoi(inputs[0]);
        m = stoi(inputs[1]);
        board = new int[n][m];
        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int a, int b) {
        for (int i = a; i < n; i++) {
            for (int j = b; j < m; j++) {
                if (board[i][j] == 0) {
                    ans++;
                    board[i][j] = 1;
                    if(search())ans--;
                    if(i<n){
                        dfs(i++,j);
                    }else{
                        dfs(i, j++);
                    }
                    board[i][j] = 0;
                }
            }
        }
    }

    static boolean search() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n && j + 1 < m) {
                    if (board[i + 1][j] == 1 && board[i][j + 1] == 1 && board[i + 1][j + 1] == 1) {
                        board[i + 1][j] = 2;
                        board[i + 1][j + 1] = 2;
                        board[i][j + 1] = 2;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int stoi(String s) {
        return Integer.valueOf(s);
    }
}
