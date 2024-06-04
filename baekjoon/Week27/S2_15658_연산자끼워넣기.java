package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_15658_연산자끼워넣기 {
    static int n;
    static int[] nums;
    static int[] operators;
    static int result_min = Integer.MAX_VALUE;
    static int result_max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(
                br.readLine()
        );
        nums = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = stoi(s[i]);
        }

        operators = new int[4];
        s = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = stoi(s[i]);
        }

        backtracking(1, nums[0]);

        System.out.println(result_max);
        System.out.println(result_min);
    }

    static void backtracking(int idx, int sum) {
        if (idx == n) {
            result_min = Math.min(result_min, sum);
            result_max = Math.max(result_max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        backtracking(idx + 1, sum + nums[idx]);
                        break;
                    case 1:
                        backtracking(idx + 1, sum - nums[idx]);
                        break;
                    case 2:
                        backtracking(idx + 1, sum * nums[idx]);
                        break;
                    case 3:
                        backtracking(idx + 1, sum / nums[idx]);
                        break;
                }
                operators[i]++;
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
