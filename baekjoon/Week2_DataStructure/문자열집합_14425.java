package baekjoon.Week2_DataStructure;

import java.util.*;
import java.io.*;

public class 문자열집합_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        int ans = 0;
        int defaultValue = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            hashMap.put(input, hashMap.getOrDefault(input, defaultValue) + 1);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            ans += hashMap.getOrDefault(input,0);
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
