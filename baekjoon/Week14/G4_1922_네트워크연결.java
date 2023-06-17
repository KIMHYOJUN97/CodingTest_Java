package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//PriorityQueue 사이즈 조심하기.
public class G4_1922_네트워크연결 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int m = stoi(br.readLine());
        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int ans = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node now = pq.poll();
            int to = now.to;
            int from = now.from;
            if(find(to)!=find(from)){
                ans+=now.value;
                union(to, from);
            }
        }
        System.out.println(ans);
    }

    static int find(int a) {
        if(a != parent[a]) parent[a] = find(parent[a]);
        return parent[a];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    static class Node implements Comparable<Node>{
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        public int compareTo(Node o){
            return this.value - o.value;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//public class G4_1922_네트워크연결 {
//    static int[] parent;
//    static ArrayList<Edge> edgeList;
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//
//        edgeList = new ArrayList<>();
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//
//            edgeList.add(new Edge(start, end, weight));
//        }
//
//        parent = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            parent[i] = i;
//        }
//
//        Collections.sort(edgeList);
//
//        int ans = 0;
//        for (int i = 0; i < edgeList.size(); i++) {
//            Edge edge = edgeList.get(i);
//
//            // 사이클이 발생하는 간선은 제외.
//            if (find(edge.start) != find(edge.end)) {
//                ans += edge.weight;
//                union(edge.start, edge.end);
//            }
//        }
//
//        bw.write(ans + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//    static class Edge implements Comparable<Edge> {
//        int start;
//        int end;
//        int weight;
//
//        Edge(int start, int end, int weight) {
//            this.start = start;
//            this.end = end;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Edge o) {
//            return weight - o.weight;
//        }
//
//    }
//
//    public static int find(int x) {
//        if (x == parent[x]) {
//            return x;
//        }
//
//        return parent[x] = find(parent[x]);
//    }
//
//    public static void union(int x, int y) {
//        x = find(x);
//        y = find(y);
//
//        if (x != y) {
//            parent[y] = x;
//        }
//    }
//
//}