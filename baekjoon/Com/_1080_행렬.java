package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * brute force로 해결 불가능 함. -> 완전 탐색 시 시간초과 발생.
 */
public class _1080_행렬 {
    static int n, m, cnt;
    static int[][] map, secondMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = stoi(s[0]);
        m = stoi(s[1]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = stoi(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                secondMap[i][j] = stoi(s[j]);
            }
        }

        if(n < 3 || m < 3){
            System.out.println(-1);
            return;
        }
        cnt = 0;

        if(check()){
            System.out.println(cnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotate(j,i);
                if(check()){
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != secondMap[i][j]) return false;
            }
        }

        return true;
    }

    static void rotate(int x, int y) {
        if (x + 2 >= m || y + 2 >= n) return;

        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (map[i][j] == 1) map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        cnt++;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
