package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G4_2015_수들의4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);

        int[] arr = new int[n];
        int[] presum = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(s[i]);
            if (i == 0) {
                presum[i] = arr[i];
            } else {
                presum[i] = presum[i - 1] + arr[i];
            }
        }

        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(presum[i] == k) ans++;
            ans += map.getOrDefault(presum[i] - k, 0);
            map.put(presum[i], map.getOrDefault(presum[i], 0) + 1);
        }
        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
