package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 *
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
 *
 * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 */

/**
 *
 *
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

 4
 */
public class S1_1931_회의실배정 {
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

        int answer = 0;
        Stack<Node> currentWork = new Stack<>();
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (currentWork.isEmpty()) {
                currentWork.add(now);
                answer++;
            } else {
                Node current = currentWork.pop();
                if (current.end <= now.start) {
                    currentWork.add(now);
                    answer++;
                }else{
                    currentWork.add(current);
                }
            }
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int time;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            time = end-start;
        }

        @Override
        public int compareTo(Node o) {
            if(end==o.end) return time-o.time;
            else return end-o.end;
        }
    }
}
