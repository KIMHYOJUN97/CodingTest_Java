package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//중복 조합
public class N_M4 {
    static List<int[]> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[] result = new int[m];
        int[] list = new int[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = i;
        }
        combi(1, n, m, 0, list, result);
        for (int[] ints : answer) {
            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                sb.append(anInt + " ");
            }
            System.out.println(sb);
        }
    }

    static void combi(int start,int n, int r, int cnt, int[] list, int[] result) {
        if (cnt == r) {
            int[] copy = result.clone();
            answer.add(copy);
            return;
        }

        for (int i = start; i <= n; i++) {
            result[cnt] = list[i];
            combi(i, n, r, cnt + 1, list, result);
        }
    }
}
