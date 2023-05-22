package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S3_2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            visited[i] = 0;
        }

        for (int i = 0; i < k; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            lists[a].add(b);
            lists[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int x : lists[1]) {
            queue.add(x);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (visited[x] == 0) {
                visited[x]=1;
                for(int y: lists[x]){
                    queue.add(y);
                }
            }

        }
        int cnt = -1;
        for (int x : visited) {
            if(x != 0)cnt++;
        }
        System.out.println(cnt);
    }
}
