package baekjoon.Week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 가장 작은 값에서 n-i개수만큼 곱해주면서 Math.max(answer,weight[i]*(n-i))을 갱신해가면 된다.
 */
public class S4_2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            int w = stoi(br.readLine());
            weight[i] = w;
        }
        Arrays.sort(weight);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (weight[i] * (n - i) > ans) {
                ans = weight[i] * (n - i);
            }
        }

        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
