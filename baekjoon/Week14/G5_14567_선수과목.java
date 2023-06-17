package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//public class G5_14567_선수과목{
//    static int[] parent;
//    static int cnt = 1;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inputs = br.readLine().split(" ");
//        int n = stoi(inputs[0]);
//        int m = stoi(inputs[1]);
//        parent = new int[n+1];
//        for (int i = 1; i <= n; i++) {
//            parent[i] = i;
//        }
//        for (int i = 0; i < m; i++) {
//            inputs = br.readLine().split(" ");
//            parent[stoi(inputs[1])] = parent[stoi(inputs[0])];
//        }
//
//        int[] ans = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            find(i);
//            ans[i] = cnt;
//            cnt = 1;
//        }
//        for (int answer : ans) {
//            if(answer==0)continue;
//            System.out.print(answer+" ");
//        }
//    }
//
//    static int find(int a) {
//        if (a != parent[a]) {
//            parent[a] = find(parent[a]);
//            cnt++;
//        }
//        return parent[a];
//    }
//
//    static int stoi(String s) {
//        return Integer.parseInt(s);
//    }
//}

public class G5_14567_선수과목{
    static List<Integer>[] parent;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = stoi(inputs[0]);
        int m = stoi(inputs[1]);
        parent = new ArrayList[n + 1];

        int[] indegree = new int[n + 1];
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = stoi(inputs[0]);
            int b = stoi(inputs[1]);
            parent[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                ans[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int x : parent[now]) {
                indegree[x]--;
                ans[x] = ans[now] + 1;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
