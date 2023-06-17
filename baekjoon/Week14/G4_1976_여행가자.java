package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_1976_여행가자 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int m = stoi(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                if (stoi(s[j-1]) == 1) {
                    union(i,j);
                }
            }
        }
        String[] s = br.readLine().split(" ");
        boolean ans = true;
        for (int i = 1; i < m; i++) {
            if(find(stoi(s[i-1]))!=find(stoi(s[i]))){
                ans = false;
                break;
            }
        }
        if(ans) System.out.println("YES");
        else System.out.println("NO");
    }

    static int find(int a) {
        if(a !=parent[a]) parent[a] = find(parent[a]);
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
