package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S4_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Boolean> map = new HashMap<>();
        int n = stoi(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            map.put(stoi(s[i]), true);
        }

        int m = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        s = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (map.containsKey(stoi(s[i]))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
