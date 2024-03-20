package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 시간초과 남.
 */
public class G5_11000_강의실배정 {
    /**
     *
     * 수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
     *
     * 김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
     *
     * 참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
     * 수강신청 대충한 게 찔리면, 선생님을 도와드리자!
     *
     * 첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
     * 이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)
     *
     * 강의실의 개수를 출력하라.
     */

    /**
3
1 3
2 4
3 5
     * <p>
     * 2
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = stoi(s[0]);
            int end = stoi(s[1]);
            pq.add(new Node(start, end));
        }

        List<Node> lectures = new ArrayList<>();

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (lectures.isEmpty()) {
                lectures.add(now);
            } else {
                boolean flag = false;
                for (int i = 0; i < lectures.size(); i++) {
                    Node cur = lectures.get(i);
                    if (cur.end <= now.start) {
                        flag = true;
                        cur.start = now.start;
                        cur.end = now.end;
                        break;
                    }
                }
                if (!flag) {
                    lectures.add(now);
                }
            }
        }

        System.out.println(lectures.size());
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int time;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            time = end - start;
        }

        @Override
        public int compareTo(Node o) {
            if (start == o.start) return time - o.time;
            else return start - o.start;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
