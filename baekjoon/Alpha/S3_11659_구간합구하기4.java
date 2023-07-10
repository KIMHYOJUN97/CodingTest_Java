package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pre_sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre_sum[i] = pre_sum[i - 1] + stoi(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = stoi(s[0]);
            int b = stoi(s[1]);
            System.out.println(pre_sum[b]-pre_sum[a-1]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
