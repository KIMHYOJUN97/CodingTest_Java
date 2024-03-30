package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 서준이는 아빠로부터 N개의 회의를 모두 진행할 수 있는 최소 회의실 개수를 구하라는 미션을 받았다.
 * <p>
 * 각 회의는 시작 시간과 끝나는 시간이 주어지고 한 회의실에서 동시에 두 개 이상의 회의가 진행될 수 없다.
 * <p>
 * 단, 회의는 한번 시작되면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * <p>
 * <p>
 * 회의의 시작 시간은 끝나는 시간보다 항상 작다. N이 너무 커서 괴로워 하는 우리 서준이를 도와주자.
 * <p>
 * 첫째 줄에 배열의 크기 N(1 ≤ N ≤ 100,000)이 주어진다.
 * <p>
 * 둘째 줄부터 N+1 줄까지 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * <p>
 * 시작 시간과 끝나는 시간은 231−1보다 작거나 같은 자연수 또는 0이다.
 * <p>
 * <p>
 * 첫째 줄에 최소 회의실 개수를 출력한다.
 */

/**
 * 첫째 줄에 배열의 크기 N(1 ≤ N ≤ 100,000)이 주어진다.
 *
 * 둘째 줄부터 N+1 줄까지 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 *
 * 시작 시간과 끝나는 시간은 231−1보다 작거나 같은 자연수 또는 0이다.
 *
 *
 * 첫째 줄에 최소 회의실 개수를 출력한다.
 */

/**
 * 3
 * 0 40
 * 15 30
 * 5 10
 *
 * 2
 *
 *2
 * 10 20
 * 5 10
 *
 * 1
 */
public class G5_19598_최소회의실개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            nodes[i] = (new Node(start, end));
            pq.add(end);
        }
        Arrays.sort(nodes);

        for (int i = 0; i < n; i++) {
            Integer end = pq.peek();
            if (nodes[i].start >= end) pq.poll();
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

        public int compareTo(Node node) {
            return start - node.start;
        }
    }
}
