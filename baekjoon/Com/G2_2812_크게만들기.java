package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * N개의 숫자가 주어졌을 때, 이 숫자들 중에서 K개를 선택하려고 한다. 이때, 선택한 숫자들의 크기를 합이 최대가 되게 하려고 한다.
 * <p>
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ K < N ≤ 500,000)
 * 둘째 줄에 N자리 숫자가 주어진다. 이 수는 0으로 시작하지 않는다.
 * <p>
 * 입력으로 주어진 숫자에서 K개를 지웠을 때 얻을 수 있는 가장 큰 수를 출력한다.
 * <p>
 * 4 2
 * 1924
 * <p>
 * 94
 * <p>
 * 7 3
 * 1231234
 * <p>
 * 10 4
 * 4177252841
 */
public class G2_2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);
        int[] arr = new int[n];
        String[] str = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(str[i]);
        }

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
