package baekjoon.Week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2473_세용액 {
    static long answer = Long.MAX_VALUE;
    static int[] ans = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(s[i]);
        }
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            solve(arr, i);
        }

        Arrays.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb);
    }

    static void solve(int[] arr, int idx) {
        int left = idx + 1;
        int right = arr.length - 1;

        while (left < right) {
            long sum = arr[idx] + arr[left] + arr[right];
            if (Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                ans[0] = arr[idx];
                ans[1] = arr[left];
                ans[2] = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
