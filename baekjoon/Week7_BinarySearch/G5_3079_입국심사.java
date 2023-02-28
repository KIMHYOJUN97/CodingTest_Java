package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_3079_입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        long[] time = new long[n];
        for (int i = 0; i < n; i++) {
            time[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(time);
        long start = 1;
        long end = time[n-1]*m;
        long ans = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start+end)/2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += mid / time[i];
            }

            if (sum >= m) {
                ans = Math.min(ans,mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
