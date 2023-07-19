package baekjoon.Week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = stoi(st.nextToken());
        }

        Arrays.sort(list);
        int a_lt = 0;
        int lt = 0;
        int a_rt = n-1;
        int rt = n-1;
        int ans = Math.abs(list[lt] + list[rt]);
        while (lt < rt) {
            int sum = list[lt]+list[rt];
            if (sum > 0) {
                if (sum < ans) {
                    a_lt = lt;
                    a_rt = rt;
                    ans = sum;
                }
                rt--;
            }else{
                if (Math.abs(sum) < ans) {
                    ans = Math.abs(sum);
                    a_lt = lt;
                    a_rt = rt;
                }
                lt++;
            }
        }
        System.out.println(list[a_lt]+" "+list[a_rt]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
