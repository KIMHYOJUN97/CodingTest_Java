package baekjoon.Week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_2252_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int[] indegree = new int[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            //m만큼의 비교
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            list[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i]==0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.peek()+" ");

            int cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int nxt = list[cur].get(i);
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }

        System.out.println(sb);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
