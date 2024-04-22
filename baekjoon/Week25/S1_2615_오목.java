package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_2615_오목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[19][19];

        for (int i = 0; i < 19; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = stoi(s[j]);
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0 && check(j, i, board)) {
                    System.out.println(board[i][j]);
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }

        System.out.println(0);

    }

    static boolean check(int x, int y, int[][] board) {
        if (x + 5 < 19) {
            boolean flag = true;
            for (int i = x + 1; i < x + 5; i++) {
                if (board[y][i] != board[y][x]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // 6번째가 같은지 확인
                if (x + 6 < 19 && board[y][x + 6] == board[y][x]) {
                    // 정답
                    return true;
                } else if (x + 6 == 19) {
                    // 정답
                    return true;
                }
            }
        }
        if (y + 5 < 19) {
            boolean flag = true;
            for (int i = y + 1; i < y + 5; i++) {
                if (board[i][x] != board[y][x]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // 6번째가 같은지 확인
                if (y + 6 < 19 && board[y + 6][x] == board[y][x]) {
                    // 정답
                    return true;
                } else if (y + 6 == 19) {
                    // 정답
                    return true;
                }
            }
        }
        if (x + 5 < 19 && y + 5 < 19) {
            boolean flag = true;
            for (int i = 1; i < 5; i++) {
                if (board[y + i][x + i] != board[y][x]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // 6번째가 같은지 확인
                if (x + 6 < 19 && y + 6 < 19 && board[y + 6][x + 6] == board[y][x]) {
                    // 정답
                    return true;
                } else if (x + 6 == 19 || y + 6 == 19) {
                    // 정답
                    return true;
                }
            }
        }

        return false;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
