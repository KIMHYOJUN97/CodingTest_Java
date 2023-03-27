package baekjoon.Week11_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 단방향인 상태에서는 union_find 사용 불가능.
 * 각 노드마다 해킹가능한 컴퓨터 수를 찾고 저장.
 * 인접행렬과 인접리스트의 장단점 숙지하기.
 */
public class S1_1325_효율적인해킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            al.get(b).add(a);
        }
        int max = 0;
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int[] visited = new int[n + 1];
            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int x : al.get(now)) {
                    if (visited[x] == 0) {
                        q.add(x);
                        visited[x]=1;
                        count++;
                    }
                }
            }
            result[i] = count;
            max = Math.max(max, count);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(result[i]==max) sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
