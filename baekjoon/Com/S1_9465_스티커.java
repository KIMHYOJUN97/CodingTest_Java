package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = stoi(br.readLine());
            int[][] arr = new int[2][n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[0][i] = stoi(s[i]);
            }

            s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[1][i] = stoi(br.readLine());
            }


        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
