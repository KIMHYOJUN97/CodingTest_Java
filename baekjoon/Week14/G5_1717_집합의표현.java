package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_1717_집합의표현 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int op = stoi(s[0]);
            int a = stoi(s[1]);
            int b = stoi(s[2]);
            if (op == 0) {
                union(a, b);
            }else{
                if(find(a)==find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static int find(int a) {
        if(a!=parent[a]) parent[a] = find(parent[a]);
        return parent[a];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
