package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G3_1005_ACM_Craft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] s = br.readLine().split(" ");
            int n = stoi(s[0]);
            int k = stoi(s[1]);
            s = br.readLine().split(" ");

            int[] time = new int[n + 1];
            List<Integer>[] building = new ArrayList[n + 1];
            int[] indegree = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                building[i] = new ArrayList<>();
            }

            for (int i = 1; i <= n; i++) {
                time[i] = stoi(s[i-1]);
            }
            for (int i = 1; i <= k; i++) {
                s = br.readLine().split(" ");
                int x = stoi(s[0]);
                int y = stoi(s[1]);
                building[x].add(y);
                indegree[y]++;
            }
            int w = stoi(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if(indegree[i]==0) q.add(i);
            }

            int[] result = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                result[i] = time[i];
            }

            while (!q.isEmpty()) {
                int now = q.poll();
                for (int x : building[now]) {
                    result[x] = Math.max(result[x], result[now] + time[x]);
                    indegree[x]--;
                    if(indegree[x]==0) q.add(x);
                }
            }
            System.out.println(result[w]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
