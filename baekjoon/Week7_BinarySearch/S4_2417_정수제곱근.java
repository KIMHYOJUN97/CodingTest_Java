package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_2417_정수제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long start = 0;
        long end = n;
        long min = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start+end)/2;
            long result = (long) Math.pow(mid, 2);
            if (result >= n) {
                min = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        System.out.println(min);
    }
}
