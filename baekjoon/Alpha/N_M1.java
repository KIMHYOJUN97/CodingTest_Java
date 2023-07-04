package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N_M1 {
    static List<int[]> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = stoi(inputs[0]);
        int m = stoi(inputs[1]);
        int[] list = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = i;
        }

        boolean[] visit = new boolean[n + 1];
        int[] result = new int[m];
        perm(n, m, 0, list, result, visit);
        for (int[] ints : answer) {
            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                sb.append(anInt + " ");
            }
            System.out.println(sb);
        }

    }

    static void perm(int n, int r, int cnt, int[] list, int[] result,boolean[] visit) {
        if (cnt == r) {
            int[] copy = result.clone();
            answer.add(copy);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(visit[i])continue;
            visit[i] = true;
            result[cnt] = list[i];
            perm(n, r, cnt + 1, list, result, visit);
            visit[i] = false;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
