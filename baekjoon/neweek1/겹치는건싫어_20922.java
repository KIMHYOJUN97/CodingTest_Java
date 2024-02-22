package baekjoon.neweek1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start =0;
        int end = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[start], map.getOrDefault(arr[start], 0) + 1);
        while (end < n) {
            if (map.get(arr[end]) <= m) {
                cnt = Math.max(cnt, end - start + 1);
                end++;
                if (end < n) {
                    map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
                }
            } else {
                map.put(arr[start], map.get(arr[start]) - 1);
                start++;
            }
        }

        System.out.println(cnt);
    }
}
