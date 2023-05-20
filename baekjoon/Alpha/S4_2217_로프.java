package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            list[i] = k;
        }
        Arrays.sort(list);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(list[i]*(n-i)>ans)ans = list[i]*(n-i);
        }
        System.out.println(ans);
    }
}
