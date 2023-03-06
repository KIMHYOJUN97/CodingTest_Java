package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_13397_구간나누기2 {
    static int n,m;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, numbers[i]);
        }

        int start = 0;
        int end = max;
        while (start < end) {
            int mid = (start+end)/2;
            if (search(mid) > m) {
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        System.out.println(end);
    }

    private static int search(int mid) {
        int cnt = 1;
        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
            if (max - min > mid) {
                cnt++;
                max = -Integer.MAX_VALUE;
                min = Integer.MAX_VALUE;
                i--;
            }
        }
        return cnt;
    }
}
