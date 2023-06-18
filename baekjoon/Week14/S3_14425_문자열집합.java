package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S3_14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            ans += map.getOrDefault(str, 0);
        }

        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
