package baekjoon.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//k번째 값은, k에서 k보다 작은 2의 제곱수중 가장 큰 것을 뺀 값의 반전값을 보여주면 된다.
public class S2_18222_투에모스문자열_분할정복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = "0";
        long k = Long.parseLong(br.readLine())-1;
        long[] pow_2 = new long[65];
        pow_2[0] = 0;
        for (int i = 1; i < 65; i++) {
            pow_2[i] = pow_2[i-1]*2;
        }

    }
}
