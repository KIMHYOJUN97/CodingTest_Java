package programmers.com;

import java.sql.Array;
import java.util.*;

public class lv2_과제진행하기 {
    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        solution(plans);
    }

    private static String[] solution(String[][] plans) {
        String[] answer = {};
        List<String> ans = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (String[] plan : plans) {
            String name = plan[0];
            String[] times = plan[1].split(":");
            int hour = Integer.parseInt(times[0]);
            int minutes = Integer.parseInt(times[1]);
            int playTime = Integer.parseInt(plan[2]);

            pq.add(new Node(name, hour * 60 + minutes, playTime));
        }

        Stack<Node> waitStack = new Stack<>();
        Stack<Node> workStack = new Stack<>();

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (workStack.isEmpty()) {
                workStack.add(now);
            }else{
                Node peek = workStack.peek();
                // 들어있던 것이 끝나면
                if (peek.start + peek.playTime <= now.start) {
                    ans.add(peek.name);
                    workStack.pop();
                    workStack.add(now);
                } else {
                    // 끝나지 않았으면 대기큐로 넣어야 함
                    // 대기큐로 들어갈 때, start 시간과 사용시간을 변경해주고 넣어야 함.
                    Node prevNode = workStack.pop();

                }
            }

        }

        return answer;
    }

    private static class Node implements Comparator<Node> {
        String name;
        int start;
        int playTime;

        public Node(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.start - o2.start;
        }
    }
}
