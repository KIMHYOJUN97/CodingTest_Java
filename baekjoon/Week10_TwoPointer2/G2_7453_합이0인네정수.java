package baekjoon.Week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_7453_합이0인네정수 {
    static int[] ab,cd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ab = new int[n*n];
        cd = new int[n*n];
        int[][] numbers = new int[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = numbers[i][0] + numbers[j][1];
                cd[idx] = numbers[i][2] + numbers[j][3];
            }
            idx++;
        }
        Arrays.sort(cd);

    }


}
