package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 회의실 문제와 비슷한 느낌이 든다.
public class G3_20440_니가싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            pq.add(new Node(stoi(s[0]), stoi(s[1])));
        }

        room.add(pq.poll().end);

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (room.peek() <= now.start) {
                room.poll();
            }
            room.add(now.end);
        }

        answer = room.size();
        

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node node) {
            if(end == node.end) return start - node.start;
            else return end - node.end;
        }
    }
}
