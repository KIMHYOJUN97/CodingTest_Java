package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G5_6443_애너그럼 {
    static List<char[]> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] chr = new char[str.length()];
            char[] result = new char[str.length()];
            boolean[] visit = new boolean[str.length()];
            for (int j = 0; j < str.length(); j++) {
                chr[j] = str.charAt(j);
            }
            Arrays.sort(chr);
            perm(str.length(), visit, 0, chr, result);
            List<String> answer = new ArrayList<>();
            for (int j = 0; j < ans.size(); j++) {
                for (char c : ans.get(j)) {
                    sb.append(c);
                }
                if(j < ans.size()-1) sb.append("\n");
            }
            sb.append("\n");
            ans.clear();
        }
        System.out.println(sb);
    }

    static void perm(int r, boolean[] visit, int cnt, char[] chr, char[] result) {
        if (cnt == r) {
            ans.add(result.clone());
            return;
        }

        for (int i = 0; i < r; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[cnt] = chr[i];
                perm(r, visit, cnt + 1, chr, result);
                visit[i] = false;
            }
        }
    }
}
