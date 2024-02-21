package baekjoon.neweek1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            pq.add(new Node(stoi(s[0]), stoi(s[1])));
        }

        int cnt = 1;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            while (!pq.isEmpty()) {
                Node next = pq.peek();
                if (now.end <= next.start) {
                    cnt++;
                    break;
                }else{
                    pq.poll();
                }
            }
        }

        System.out.println(cnt);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    private static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } else if (this.end < o.end) {
                return -1;
            } else return 1;
        }

    }
}
