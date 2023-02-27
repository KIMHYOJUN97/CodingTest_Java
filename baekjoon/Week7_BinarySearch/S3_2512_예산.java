package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int target = Integer.parseInt(br.readLine());

        int ans = target/n;
        int start = target / n;
        int end = numbers[n - 1];
        int prev_ans=0;
        int prev_end = 0;
        while(true) {
            int mid = (int)Math.ceil(((double)start + (double)end) / 2);
            if (numbers[0] >= target / n) {
                break;
            } else {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (mid - numbers[i] > 0) sum += (mid - numbers[i]);
                }
                if (sum + target >= mid * n) {
                    prev_ans = ans;
                    ans = mid;
                    start = mid;
                }
                else{
                    prev_end = end;
                    end = mid;
                }
                if(prev_ans==ans||prev_end==end)break;
            }
        }
        System.out.println(ans);
    }

}
