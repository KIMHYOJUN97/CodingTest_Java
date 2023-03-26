package baekjoon.Week11_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S2_11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] al = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            al[a].add(b);
            al[b].add(a);
        }
        int[] ans = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int x : al[now]) {
                if (ans[x] == 0) {
                    ans[x] = now;
                    queue.add(x);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(ans[i] + "\n");
        }
        System.out.println(sb);
    }
}
