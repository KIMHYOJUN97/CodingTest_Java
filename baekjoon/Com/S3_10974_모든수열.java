package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S3_10974_모든수열 {
    static List<int[]> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        int[] result = new int[n];
        boolean[] visit = new boolean[n];
        dfs(0, arr, result, visit);

        StringBuilder sb = new StringBuilder();
        for (int[] ints : answer) {
            for (int anInt : ints) {
                sb.append(anInt + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int[] arr, int[] result, boolean[] visit) {
        if (idx == arr.length) {
            int[] copy = result.clone();
            answer.add(copy);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[idx] = arr[i];
                dfs(idx + 1, arr, result, visit);
                visit[i] = false;
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
