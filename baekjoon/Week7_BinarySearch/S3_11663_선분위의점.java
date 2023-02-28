package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_11663_선분위의점 {
    static long[] dots;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        dots = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dots[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(dots);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int ans = binarySearch(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static int binarySearch(Long x, Long y) {
        int start = 0;
        int end = n-1;
        int endPoint = 0;
        int startPoint = 0;
        while (start <= end) {
            int mid = (start+end)/2;
            if (dots[mid] > y) {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        endPoint = end + 1;

        start = 0;
        end = n-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (dots[mid] < x) {
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        startPoint = start;
        return endPoint - startPoint;
    }
}
