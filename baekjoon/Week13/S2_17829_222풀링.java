package baekjoon.Week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S2_17829_222풀링 {

    static int n, ans;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = stoi(inputs[j]);
            }
        }

        System.out.println(dfs(0, 0, n));

    }

    static int dfs(int row, int col, int size) {
        if (size == 2) {
            int arr[] = new int[4];
            int idx = 0;
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    arr[idx++] = board[i][j];
                }
            }
            Arrays.sort(arr);
            return arr[2];
        } else {
            int arr[] = new int[4];
            size /= 2;

            arr[0] = dfs(row, col, size);
            arr[1] = dfs(row + size, col, size);
            arr[2] = dfs(row, col + size, size);
            arr[3] = dfs(row + size, col + size, size);
            Arrays.sort(arr);
            return arr[2];
        }
    }
//    static int dfs(int row, int col, int size,int[][] boarding) {
//        if (size == 2) {
//            return search(row, col, size, boarding);
//        }
//        else{
//            size/=2;
//
//        }
//
//    }
//
//    static int search(int row, int col, int size,int[][] boarding) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = row; i < row + size; i++) {
//            for (int j = col; j < col + size; j++) {
//                list.add(boarding[i][j]);
//            }
//        }
//        Collections.sort(list);
//
//        return list.get(2);
//    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
