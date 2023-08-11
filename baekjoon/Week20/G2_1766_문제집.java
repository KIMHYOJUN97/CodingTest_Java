package baekjoon.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 위상정렬
 * 순차대로 넣어줌으로써 쉬운 문제(수의 크기가 작은 것)부터 차례대로 indegree를 순회한다.
 */
public class G2_1766_문제집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            list.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");

            for (int nxt : list.get(now)) {
                indegree[nxt]--;

                if(indegree[nxt]==0) pq.add(nxt);
            }
        }

        System.out.println(sb.toString());

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
