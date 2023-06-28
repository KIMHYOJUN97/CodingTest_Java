package baekjoon.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S4_1969_DNA_완전탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);

        String[] dna = new String[n];
        for (int i = 0; i < n; i++) {
            dna[i]= br.readLine();
        }
        String ans = "";
        int ans_cnt = 0;
        for (int j = 0; j < m; j++) {
            Node a = new Node("A", 0);
            Node t = new Node("T", 0);
            Node g = new Node("G", 0);
            Node c = new Node("C", 0);
            for (int i = 0; i < n; i++) {
                if(dna[i].charAt(j)=='A')a.cnt++;
                else if(dna[i].charAt(j)=='T')t.cnt++;
                else if(dna[i].charAt(j)=='C')c.cnt++;
                else g.cnt++;
            }
            Node[] cnt = {a, t, g, c};
            Arrays.sort(cnt);
            ans += cnt[0].category;
            ans_cnt += (n - cnt[0].cnt);
        }

        System.out.println(ans);
        System.out.println(ans_cnt);
    }

    static class Node implements Comparable<Node> {
        String category;
        int cnt;

        public Node(String category, int cnt) {
            this.category = category;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if(this.cnt == node.cnt) return this.category.compareTo(node.category);
            else return node.cnt - this.cnt;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
