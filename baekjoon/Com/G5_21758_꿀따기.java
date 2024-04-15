package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_21758_꿀따기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] presum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(s[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) presum[i] = arr[i];
            else presum[i] = presum[i - 1] + arr[i];
        }


        int answer = 0;
        for (int i = 1; i < n; i++) {
            answer = Math.max(presum[i] - presum[0] + presum[n - 1] - presum[i - 1], answer);
            answer = Math.max(presum[n - 1] * 2 - presum[i] * 2 + presum[i - 1] - presum[0], answer);
            answer = Math.max(presum[i - 1] * 2 + presum[n - 2] - presum[i], answer);
        }

        System.out.println(answer);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
