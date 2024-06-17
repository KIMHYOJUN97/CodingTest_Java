package programmers.repeat1;

import java.util.PriorityQueue;
import java.util.Stack;

public class lv2_요격시스템 {
    public static void main(String[] args) {

        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        solution(targets);
    }

    public static void solution(int[][] targets) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int[] target : targets) {
            pq.add(new Node(target[0], target[1]));
        }

        int answer = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(pq.poll().end);
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(stack.peek() <= now.start){
                stack.pop();
                stack.add(now.end);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.end - o.end;
        }
    }
}
