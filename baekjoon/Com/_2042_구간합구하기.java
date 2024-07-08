package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _2042_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        int k = stoi(s[2]);
        int[] list = new int[n];
        int[] presum = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            list[i] = stoi(br.readLine());
            presum[i + 1] = presum[i] + list[i];
        }

        List<Node> container = new ArrayList<>();

        for (int i = 0; i < m + k; i++) {
            s = br.readLine().split(" ");
            int a = stoi(s[0]);
            int b = stoi(s[1]);
            int c = stoi(s[2]);

            if (a == 1) {
                container.add(new Node(b, c));
            } else {
                // presum[c]
                int presumC = presum[c];
                int presumB = presum[b-1];
                for (int j = 0; j < container.size(); j++) {
                    Node now = container.get(j);
                    // 무시안됨.
                    if (now.b <= c) {
                        presumC -= list[now.b - 1];
                        presumC += now.c;
                    }

                    if (now.b <= b) {
                        presumB -= list[now.b - 1];
                        presumB += now.c;
                    }
                }

                sb.append(presumC - presumB + "\n");
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int b;
        int c;

        public Node(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
