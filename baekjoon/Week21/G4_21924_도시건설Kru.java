package baekjoon.Week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G4_21924_도시건설Kru {
    static int[] parent;
    static int n,m;
    static List<Node> cities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        parent = new int[n + 1];
        cities = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        long total = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int cost = stoi(st.nextToken());
            cities.add(new Node(from, to, cost));
            total += cost;
        }

        Collections.sort(cities);
        int cnt = 0;
        long sum = 0;
        for (Node city : cities) {
            if (union(city.from, city.to)) {
                cnt++;
                sum+= city.cost;
            }
        }

        System.out.println(cnt == n-1 ? total-sum : -1);

    }

    static boolean union(int from, int to) {
        from = find(from);
        to = find(to);

        if(from == to)return false;
        else parent[to] = from;
        return true;
    }

    static int find(int x) {
        if(parent[x] != x) return parent[x] = find(parent[x]);
        return x;
    }

    static class Node implements Comparable<Node> {

        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return cost - node.cost;
        }
    }


    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
