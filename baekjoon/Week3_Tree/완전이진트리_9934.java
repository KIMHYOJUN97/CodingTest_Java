package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 완전이진트리_9934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer>[] tree = new ArrayList[k+1];

        for (int i = 0; i < k + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        while (st.hasMoreTokens()) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        dfs(al, 0,tree);
        for (ArrayList<Integer> x : tree) {
            for (Integer y : x) {
                sb.append(y+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }



    static void dfs(ArrayList<Integer> al, Integer idx,ArrayList<Integer>[] tree) {
        //mid값은 완전이진트리의 중간값이 root인 것을 나타낸다.
        int mid = (al.size()) / 2;
        tree[idx].add(al.get(mid));
        if(al.size()==0) return;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            start.add(al.get(i));
        }
        for (int i = mid; i < al.size(); i++) {
            end.add(al.get(i));
        }
        dfs(start, idx + 1,tree);
        dfs(end, idx + 1, tree);
    }
}
