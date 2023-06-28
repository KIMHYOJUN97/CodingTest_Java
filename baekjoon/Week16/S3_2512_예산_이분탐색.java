package baekjoon.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2512_예산_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] money = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            money[i] = stoi(inputs[i]);
            max = Math.max(money[i], max);
        }
        int m = stoi(br.readLine());
        int start = 0;
        int end = max;
        int ans = 0;
        while (start <= end) {
            //평균 가격.
            int mid = (start+end)/2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (money[i] > mid) {
                    sum += mid;
                }else{
                    sum += money[i];
                }
            }
            //가능
            if (sum > m) {
                end = mid-1;
            }else{
                ans = Math.max(mid, ans);
                start = mid+1;
            }
        }
        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
