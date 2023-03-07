package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_1939_중량제한 {
    static int n,m,a,b;
    static ArrayList<Node> graph[];
    static int[] dist;
    static final int INF = 1000000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }
        input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);


    }

    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> (o2.weight - o1.weight)));
        pq.offer(new Node(a, INF));
        dist[a] = INF;
        while (!pq.isEmpty()) {
            int from = pq.peek().to;
            int weight = pq.peek().weight;
            pq.poll();
            if(dist[from]>weight) continue;
            for (int i = 0; i < graph[from].size(); i++) {
                int to = graph[from].get(i).to;
                int weightTo = Math.min(weight, graph[from].get(i).weight);
                if (weightTo > dist[to]) {
                    dist[to] = weightTo;
                    pq.offer(new Node(to, weightTo));
                }
            }
        }
    }
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
