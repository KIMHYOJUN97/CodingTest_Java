package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * backtracking -> 시간초과
 */
public class G5_5557_1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n];
        long[][] dp = new long[n][21];

        for (int i = 0; i < n; i++) {
            nums[i] = stoi(s[i]);
        }

        dp[0][nums[0]] = 1;

        int plus;
        int minus;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    plus = j + nums[i];
                    minus = j - nums[i];
                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 2][nums[n - 1]]);


    }


    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
//public class G5_5557_1학년 {
//    static long answer = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = stoi(br.readLine());
//        String[] s = br.readLine().split(" ");
//        int[] nums = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = stoi(s[i]);
//        }
//
//        backtracking(0, 0, nums);
//        System.out.println(answer);
//    }
//
//    static void backtracking(int sum, int idx, int[] nums) {
//        if (sum < 0 || sum > 20) return;
//        if (idx == nums.length - 1) {
//            if (sum == nums[nums.length - 1]) answer++;
//            return;
//        }
//
//        backtracking(sum + nums[idx], idx + 1, nums);
//        backtracking(sum - nums[idx], idx + 1, nums);
//
//    }
//
//    static int stoi(String s) {
//        return Integer.parseInt(s);
//    }
//}
