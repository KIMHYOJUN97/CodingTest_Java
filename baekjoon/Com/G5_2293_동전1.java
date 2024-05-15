package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
 *
 * 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
 *
 * 첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.
 *
 * 첫째 줄에 경우의 수를 출력한다. 경우의 수는 231보다 작다.
 *
 * 3 10
 * 1
 * 2
 * 5
 *
 * 10
 *
 */

/**
 * for (int j = arr[i]; j <= k; j++) {
 *                 dp[j] += dp[j - arr[i]];
 *             }
 *
 *             -> 공식임
 */
public class G5_2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);

        int[] dp = new int[k + 1];
        dp[0] = 1;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = stoi(br.readLine());
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
