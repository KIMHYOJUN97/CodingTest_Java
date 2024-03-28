package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_13164_행복유치원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);
        s = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = stoi(s[i]);
        }

        int[] closeNums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            closeNums[i] = nums[i + 1] - nums[i];
        }

        Arrays.sort(closeNums);

        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += closeNums[i];
        }

        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
