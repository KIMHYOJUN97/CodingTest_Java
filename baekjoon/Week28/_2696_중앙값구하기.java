package baekjoon.Week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2696_중앙값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            int n = stoi(br.readLine());

            int cnt = 0;

            StringBuilder sb = new StringBuilder();
            StringTokenizer st = null;

            sb.append((n + 1) / 2 + "\n");

            for (int i = 0; i < n; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = stoi(st.nextToken());
                if (maxPQ.size() == minPQ.size()) {
                    maxPQ.add(x);
                } else {
                    minPQ.add(x);
                }

                if (!minPQ.isEmpty()) {
                    if (maxPQ.peek() > minPQ.peek()) {
                        int t1 = maxPQ.poll();
                        int t2 = minPQ.poll();

                        maxPQ.add(t2);
                        minPQ.add(t1);
                    }
                }

                if (i % 2 == 0) {
                    if (cnt == 9 || i == n - 1) {
                        sb.append(maxPQ.peek() + "\n");
                        cnt = 0;
                    } else {
                        sb.append(maxPQ.peek() + " ");
                    }

                    cnt++;
                }
            }

            System.out.println(sb.toString());
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
