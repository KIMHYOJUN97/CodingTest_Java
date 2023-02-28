package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        long[] line = new long[n];
        for (int i = 0; i < n; i++) {
            line[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(line);
        long start = 0;
        long end = line[n - 1];
//        int ans = 0;
        while (start <= end) {
            long mid = (start+end)/2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(line[i]>mid)sum+=(line[i]/mid);
            }
            if(sum<target)end = mid-1;
            else{
                start = mid+1;
            }
        }
        System.out.println(end);
    }
}
