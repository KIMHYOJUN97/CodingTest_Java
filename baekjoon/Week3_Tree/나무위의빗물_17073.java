package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 나무위의빗물_17073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            String[] ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            tree[a].add(b);
            tree[b].add(a);
        }

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if(tree[i].size()==1) cnt++;
        }

        System.out.println((double)w/cnt);
    }
}
