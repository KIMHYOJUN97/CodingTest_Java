package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 트리의지름_1967 {

    static int ans;
    static int[] visited;
    static ArrayList<Node>[] tree;
    static int m_idx=1;

    static class Node{
        int num;
        int len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    static void dfs(int num, int sum) {
        if (ans < sum) {
            ans = sum;
            m_idx = num;
        }

        for (Node node : tree[num]) {
            if(visited[node.num]==0){
            visited[node.num] = 1;
            dfs(node.num, sum + node.len);}
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        visited = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int len = Integer.parseInt(input[2]);

            tree[p].add(new Node(c, len));
            tree[c].add(new Node(p, len));
        }

        visited[1] = 1;
        dfs(1, 0);

        visited = new int[n + 1];
        visited[m_idx] = 1;
        dfs(m_idx, 0);
        System.out.println(ans);
    }
}
