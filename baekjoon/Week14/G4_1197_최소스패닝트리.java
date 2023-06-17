package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class G4_1197_최소스패닝트리 {
    static int v,e;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        v = stoi(s[0]);
        e = stoi(s[1]);
        list = new ArrayList[v+1];
        visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a = stoi(s[0]);
            int b = stoi(s[1]);
            int w = stoi(s[2]);
            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        int total = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int node = now.to;
            int weight = now.value;

            if(visited[node]) continue;
            visited[node] = true;
            total += weight;

            for (Node next : list[node]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }
        System.out.println(total);

    }

    static class Node implements Comparable<Node> {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }


    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

//크루스칼 알고리즘 -> Union Find + Priority Queue : 메모리 초과
//public class G4_1197_최소스패닝트리 {
//    static int v,e;
//    static int[][] graph;
//    static int[] parent;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = br.readLine().split(" ");
//        v = stoi(s[0]);
//        e = stoi(s[1]);
//        graph = new int[v+1][e+1];
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        for (int i = 1; i <= e; i++) {
//            s = br.readLine().split(" ");
//            int a = stoi(s[0]);
//            int b = stoi(s[1]);
//            int val = stoi(s[2]);
//            pq.add(new Node(b,a, val));
//        }
//        parent = new int[v + 1];
//        for (int i = 1; i <= v; i++) {
//            parent[i] = i;
//        }
//
//        int size = pq.size();
//        int total = 0;
//        for (int i = 0; i < size; i++) {
//            Node node = pq.poll();
//            int rx = find(node.to);
//            int ry = find(node.from);
//
//            if (rx != ry) {
//                total += node.value;
//                union(node.to, node.from);
//            }
//        }
//
//        System.out.println(total);
//    }
//
//    static void union(int a, int b) {
//        a = find(a);
//        b = find(b);
//        if (a < b) {
//            parent[b] = a;
//        }else{
//            parent[a] = b;
//        }
//    }
//
//    static int find(int a) {
//        if(parent[a] !=a) parent[a] = find(parent[a]);
//        return parent[a];
//    }
//
//    static class Node implements Comparable<Node> {
//        int to;
//        int from;
//        int value;
//
//        public Node(int to, int from, int value) {
//            this.to = to;
//            this.from = from;
//            this.value = value;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            if(this.value<o.value)return this.value-o.value;
//            else return 1;
//        }
//    }
//
//
//    static int stoi(String s) {
//        return Integer.parseInt(s);
//    }
//}
