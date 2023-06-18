package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S2_11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] parent = new int[n + 1];

        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = stoi(s[0]);
            int b = stoi(s[1]);
            lists[a].add(b);
            lists[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int x : lists[now]) {
                if (parent[x] == 0) {
                    parent[x] = now;
                    queue.add(x);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
