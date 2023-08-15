package baekjoon.Week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class S4_11508_2_1세일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(i%3==2)continue;
            ans += arr[i];
        }

        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
