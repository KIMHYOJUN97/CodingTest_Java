package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 가장가까운공통조상_3584 {
    //parent list에서 0이 head의 조상이다. 원하는 값은 head까지의 거리니 -1을 반환해준다.
    static int find_depth(int n, int[] parent) {
        int depth = 0;
        int now = n;
        while (now != 0) {
            depth++;
            now = parent[now];
        }
        return depth - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] tree = new ArrayList[n + 1];

            for (int i = 0; i < n + 1; i++) {
                tree[i] = new ArrayList<>();
            }

            int[] parent = new int[n + 1];

            for (int i = 0; i < n - 1; i++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                parent[b] = a;
                tree[a].add(b);
            }

            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int[] depth = new int[2];
            depth[0] = find_depth(a, parent);
            depth[1] = find_depth(b, parent);

            if (depth[0] > depth[1]) {
                while (depth[0] > depth[1]) {
                    a = parent[a];
                    depth[0]--;
                }
            } else if (depth[0] < depth[1]) {
                while (depth[0] < depth[1]) {
                    b = parent[b];
                    depth[1]--;
                }
            } else {
                while (a != b) {
                    a = parent[a];
                    b = parent[b];
                }
            }

            sb.append(a + "\n");
        }
        System.out.println(sb);
    }
}
