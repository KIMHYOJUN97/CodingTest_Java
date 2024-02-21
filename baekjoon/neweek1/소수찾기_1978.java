package baekjoon.neweek1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while (st.hasMoreTokens()) {
            if(isPrime(Integer.parseInt(st.nextToken()))) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for (int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
