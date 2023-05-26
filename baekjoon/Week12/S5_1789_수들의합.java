package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 0;
        for (int i = 1; sum < n; i++) {
            sum += i;
            cnt=i;
        }
        System.out.println(cnt-1);
    }
}
