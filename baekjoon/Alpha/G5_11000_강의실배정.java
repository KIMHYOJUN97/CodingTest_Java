package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G5_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            nodes[i] = new Node(a,b);
        }

        Arrays.sort(nodes);

        //우선순위 큐에는 종료 시간만 들어감
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nodes[0].end);

        for (int i = 1; i < n; i++) {
            //pq의 끝 시간이 nodes에 들어있는 시작 시간보다 크다면 강의실을 재사용한다.
            if (pq.peek() <= nodes[i].start) {
                pq.poll();
            }
            pq.add(nodes[i].end);
        }

        System.out.println(pq.size());
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //시작 시간이 같으면 끝나는 시간이 빠른 순으로 정렬
        //다르다면 시작시간이 같은 순서로 정렬
        @Override
        public int compareTo(Node o) {
            if(this.start==o.start)return this.end-o.end;
            else return this.start-o.start;
        }
    }

}
