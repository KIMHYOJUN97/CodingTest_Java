package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N_M2 {
    static List<int[]> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[] list = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = i;
        }
        int[] result = new int[m];
        combi(n, m, list, result, 0, 1);
        for (int[] ints : answer) {
            StringBuilder sb = new StringBuilder();
            for (int x : ints) {
                sb.append(x + " ");
            }
            System.out.println(sb);
        }
    }

    static void combi(int n, int r, int[] list, int[] result, int cnt, int start) {
        if (cnt == r) {
            int[] copy = result.clone();
            answer.add(copy);
            return;
        }

        for (int i = start; i <= n; i++) {
            result[cnt] = list[i];
            combi(n, r, list, result, cnt + 1, i + 1);
        }
    }

}
