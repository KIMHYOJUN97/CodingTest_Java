package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_1717_집합의표현 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = stoi(inputs[0]);
        int m = stoi(inputs[1]);
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            if (stoi(inputs[0])==0) {
                union(stoi(inputs[1]),stoi(inputs[2]));
            } else if (stoi(inputs[1]) == 1) {
                if(find(stoi(inputs[1]))==find(stoi(inputs[2]))) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static int find(int a) {
        if (a != parent[a]) parent[a] = find(parent[a]);
        return parent[a];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a==b) return;
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
