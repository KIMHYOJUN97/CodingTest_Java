package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2_16953_A_B {
    static long b;
    static List<Long> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long a = Integer.parseInt(inputs[0]);
        b = Integer.parseInt(inputs[1]);
        dfs(a,0);

        Collections.sort(ans);
        if(ans.size()==0) System.out.println(-1);
        else System.out.println(ans.get(0)+1);
    }

    private static void dfs(long a,long cnt) {
        if(a > b) return;
        if(a==b) {
            ans.add(cnt);
            return;
        }

        dfs(a*2,cnt+1);
        dfs(a * 10 + 1, cnt+1);
    }
}
