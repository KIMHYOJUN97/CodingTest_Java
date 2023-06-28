package baekjoon.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//public class S1_1325_효율적인해킹_그래프 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = br.readLine().split(" ");
//        int n = stoi(s[0]);
//        int m = stoi(s[1]);
//        int[] indegree = new int[n+1];
//
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < m; i++) {
//            s = br.readLine().split(" ");
//            int a = stoi(s[0]);
//            int b = stoi(s[1]);
//            list.get(b).add(a);
//        }
//        int[] result = new int[n + 1];
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i <= n; i++) {
//            boolean[] visited = new boolean[n+1];
//            int count = 0;
//            Queue<Integer> q = new LinkedList<>();
//            q.add(i);
//            visited[i] = true;
//            while (!q.isEmpty()) {
//                int v = q.poll();
//                for (int idx : list.get(v)) {
//                    if (!visited[idx]) {
//                        q.add(idx);
//                        visited[idx] = true;
//                        count++;
//                    }
//                }
//            }
//            result[i] = count;
//            max = Math.max(max,count);
//
//        }
//        for (int i = 1; i <= n; i++) {
//            if (result[i] == max) {
//                System.out.print(i+" ");
//            }
//        }
//    }
//
//    static int stoi(String s) {
//        return Integer.parseInt(s);
//    }
//}

//한 컴퓨터 당 얼마나 해킹할 수 있는가 ->모두를 해킹하는 것 중 가장 수가 적은 컴퓨터를 해킹하는 것이 아니다.
public class S1_1325_효율적인해킹_그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        int[] indegree = new int[n+1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        List<Integer> answer = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = stoi(s[0]);
            int b = stoi(s[1]);
            indegree[a]+=1;
            list.get(b).add(a);
        }
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int cnt = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int v = q.poll();
                for (int k : list.get(v)) {
                    if (!visited[k]) {
                        q.add(k);
                        visited[k] = true;
                        cnt++;
                    }
                }
            }
            result[i] = cnt;
        }
        for(int i=1;i<=n;i++){
            min = Math.min(min, indegree[i]);
        }
        for (int i = 1; i <= n; i++) {
            if(indegree[i]==min) answer.add(i);
        }

        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer+" ");
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
