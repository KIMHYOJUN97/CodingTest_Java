package baekjoon.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S1_1992_쿼드트리_분할정복 {
    static int[][] board;
    static ArrayList<String> ans = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = stoi(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = stoi(split[j]);
            }
        }

        find(0, 0, n);
        String answer = "";
        for (int i = 0; i < ans.size(); i++) {
            answer += ans.get(i);
        }
        System.out.println(answer);
    }

    static boolean check(int x, int y, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != board[y][x]) return false;
            }
        }

        return true;
    }

    //size는 나눠준 수.->범위를 나타내기에 용이함
    //순서 상관이 있음. ->재귀할 때, 어디부터 탐색해줄 것 인가.
    static void find(int x, int y, int size) {
        if (check(x, y, size)) {
            ans.add(String.valueOf(board[y][x]));
            return;
        }

        int new_size = size / 2;

        ans.add("(");
        find(x, y, new_size);
        find(x + new_size, y, new_size);
        find(x, y + new_size, new_size);
        find(x + new_size, y + new_size, new_size);
        ans.add(")");
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
