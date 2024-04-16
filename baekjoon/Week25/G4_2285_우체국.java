package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class G4_2285_우체국 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());

        long sum = 0;
        long cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = stoi(s[0]);
            int a = stoi(s[1]);
            pq.add(new Node(x, a));
            sum += a;
        }

        for (int i = 0; i < n; i++) {
            Node now = pq.poll();
            cnt += now.value;
            if (cnt >= (sum + 1) / 2) {
                System.out.println(now.idx);
                break;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(idx == o.idx) return value - o.value;
            return idx - o.idx;
        }
    }

    static long stol(String s) {
        return Long.parseLong(s);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
