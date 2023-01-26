package baekjoon.Week3_Tree;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class 트리의부모찾기_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] al = new ArrayList[N+1];
//        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            al[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            al[b].add(a);
//            al.get(b).add(a);
//            al.get(a).add(b);
        }
        int[] ans = new int[N + 1];
        ArrayList<Integer> root = new ArrayList<>();
//        for (int i = 1; i < N + 1; i++) {
//            for (int x : al[i]) {
//                if(x == 1) root.add(i);
//                if(i == 1) root.add(x);
//            }
//        }

//        for (int i = 1; i < N + 1; i++) {
//            for (int x : al[i]) {
//                int flag = 0;
//                for (int j = 0; j < root.size(); j++) {
//                    if(x== root.get(j)) flag = 1;
//                }
//                if (flag == 1) {
//
//                }
//            }
//        }
        Queue<Integer> dq = new LinkedList<>();

        dq.add(1);

        while (!dq.isEmpty()) {
            int now = dq.poll();
            for (int x : al[now]) {
                if (ans[x] == 0) {
                    ans[x] = now;
                    dq.add(x);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(ans[i] + "\n");
        }
        System.out.println(sb);
    }
}
