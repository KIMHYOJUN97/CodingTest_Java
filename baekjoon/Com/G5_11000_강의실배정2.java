package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class G5_11000_강의실배정2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer> lectures = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = stoi(s[0]);
            int end = stoi(s[1]);

            pq.add(new Node(start, end));
        }
        int answer = 0;

        lectures.add(pq.poll().end);

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (lectures.peek() <= now.start) {
                lectures.poll();
            }
            lectures.add(now.end);
        }
        answer = lectures.size();
        System.out.println(answer);

    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node o) {
            if (start == o.start) return end - o.end;
            else return start - o.start;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
