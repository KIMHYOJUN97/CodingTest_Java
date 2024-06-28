package programmers;

import java.util.PriorityQueue;

public class lv2_호텔대실 {

    class Solution {
        public int solution(String[][] book_time) {
            int answer = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < book_time.length; i++) {
                String[] start1 = book_time[i][0].split(":");
                String[] end1 = book_time[i][1].split(":");
                int start = Integer.parseInt(start1[0]) * 60 + Integer.parseInt(start1[1]);
                int end = Integer.parseInt(end1[0]) * 60 + Integer.parseInt(end1[1]);

                pq.add(new Node(start, end));
            }

            PriorityQueue<Integer> rooms = new PriorityQueue<>();
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (rooms.isEmpty()) rooms.add(now.end);
                else {
                    if (rooms.peek() + 10 <= now.start) {
                        rooms.poll();
                    }
                    rooms.add(now.end);
                }

                answer = Math.max(answer, rooms.size());
            }
            return answer;
        }

        class Node implements Comparable<Node> {
            int start;
            int end;

            public Node(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Node o) {
                return this.start - o.start;
            }
        }
    }
}
