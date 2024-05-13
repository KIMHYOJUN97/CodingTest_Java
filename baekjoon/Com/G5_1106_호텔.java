package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 세계적인 호텔인 형택 호텔의 사장인 김형택은 이번에 수입을 조금 늘리기 위해서 홍보를 하려고 한다.
 * <p>
 * 형택이가 홍보를 할 수 있는 도시가 주어지고, 각 도시별로 홍보하는데 드는 비용과, 그 때 몇 명의 호텔 고객이 늘어나는지에 대한 정보가 있다.
 * <p>
 * 예를 들어, “어떤 도시에서 9원을 들여서 홍보하면 3명의 고객이 늘어난다.”와 같은 정보이다. 이때, 이러한 정보에 나타난 돈에 정수배 만큼을 투자할 수 있다.
 * 즉, 9원을 들여서 3명의 고객, 18원을 들여서 6명의 고객, 27원을 들여서 9명의 고객을 늘어나게 할 수 있지만, 3원을 들여서 홍보해서 1명의 고객, 12원을 들여서 4명의 고객을 늘어나게 할 수는 없다.
 * <p>
 * 각 도시에는 무한 명의 잠재적인 고객이 있다. 이때, 호텔의 고객을 적어도 C명 늘이기 위해 형택이가 투자해야 하는 돈의 최솟값을 구하는 프로그램을 작성하시오.
 * <p>
 * <p>
 * 첫째 줄에 C와 형택이가 홍보할 수 있는 도시의 개수 N이 주어진다. C는 1,000보다 작거나 같은 자연수이고, N은 20보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 각 도시에서 홍보할 때 대는 비용과 그 비용으로 얻을 수 있는 고객의 수가 주어진다. 이 값은 100보다 작거나 같은 자연수이다.
 * <p>
 * 첫째 줄에 문제의 정답을 출력한다.
 * <p>
 * 12 2
 * 3 5
 * 1 1
 * <p>
 * 8
 */

/**
 * cost는 낮게, customer는 높게
 */
public class G5_1106_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int c = stoi(s[0]);
        int n = stoi(s[1]);
        int[] dp = new int[c + 101];
        for (int i = 0; i < c + 101; i++) {
            dp[i] = 1000000;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int co = stoi(s[0]);
            int cus = stoi(s[1]);
            for (int j = cus; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - cus] + co);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = c; i < c + 101; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
