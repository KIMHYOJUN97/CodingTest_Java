package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_2412_암벽등반 {
    static int n;
    static int T;
    static int[][] rocks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        T = Integer.parseInt(input[1]);
        rocks = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rocks[i][0] = Integer.parseInt(st.nextToken());
            rocks[i][1] = Integer.parseInt(st.nextToken());
        }

    }
}
