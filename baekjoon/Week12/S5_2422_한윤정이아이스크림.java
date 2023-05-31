package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S5_2422_한윤정이아이스크림 {

    static int n, m;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        board = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            board[a][b] = 1;
            board[b][a] = 1;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (board[i][j] == 1) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (board[j][k] != 1 && board[k][i] != 1) result++;
                }
            }
        }
        System.out.println(result);
    }

//    static int[] index;
//    static int[] output;
//    static int n,r;
//    static boolean[] visited;
//    static int[][] board;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inputs = br.readLine().split(" ");
//        n = Integer.parseInt(inputs[0]);
//        r = Integer.parseInt(inputs[1]);
//        board = new int[n + 1][n + 1];
//        for (int i = 0; i < r; i++) {
//            inputs = br.readLine().split(" ");
//            int a = Integer.parseInt(inputs[0]);
//            int b = Integer.parseInt(inputs[1]);
//            board[a][b] = 1;
//            board[b][a] = 1;
//        }
//
//        output = new int[3];
//        lists = new ArrayList<>();
//        combi(0,1);
//        int ans = 0;
//        for (int[] list : lists) {
//
//        }
//
//
//    }
//    static List<int[]> lists;
//
//    static void validation(int properties,int[] tmp) {
//        for (int x : board[properties]) {
//
//        }
//    }
//
//    static void combi(int cnt, int start) {
//        if(cnt == 3){
//            int[] deepcopy = output.clone();
//            lists.add(deepcopy);
//            return;
//        }
//
//        for (int i = start; i <= n; i++) {
//            output[cnt] = i;
//            combi(cnt + 1, i+1);
//        }
//    }
}
