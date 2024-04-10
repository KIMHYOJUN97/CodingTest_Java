package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자 1, 2, 3으로만 이루어지는 수열이 있다. 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면, 그 수열을 나쁜 수열이라고 부른다. 그렇지 않은 수열은 좋은 수열이다.
 * <p>
 * 다음은 나쁜 수열의 예이다.
 * <p>
 * 33
 * 32121323
 * 123123213
 * 다음은 좋은 수열의 예이다.
 * <p>
 * 2
 * 32
 * 32123
 * 1232123
 * <p>
 * 길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램을 작성하라. 예를 들면, 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수열은 1213121이다.
 * <p>
 * 입력은 숫자 N하나로 이루어진다. N은 1 이상 80 이하이다.
 * <p>
 * 첫 번째 줄에 1, 2, 3으로만 이루어져 있는 길이가 N인 좋은 수열들 중에서 가장 작은 수를 나타내는 수열만 출력한다. 수열을 이루는 1, 2, 3들 사이에는 빈칸을 두지 않는다.
 * <p>
 * 7
 * <p>
 * 1213121
 */
public class G4_2661_좋은수열 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(1, 1, 0);
    }

    static void dfs(long num, int idx, int plus) {
        if (check(num, idx)) return;
        if (idx == n) {
            System.out.println(num);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (plus == i) continue;
            dfs(num * 10 + i, idx + 1, i);
        }
    }

    static boolean check(long num, int idx) {
        String s = String.valueOf(num);
        if (divideconquer(s)) {
            return false;
        }

        return true;
    }

    static boolean divideconquer(String num) {
        int length = num.length();
        if (length == 1) {
            return true;
        }

        String s1 = "";
        String s2 = "";
        for (int i = 0; i < length / 2; i++) {
            s1 += num.charAt(i);
        }

        for (int i = length / 2; i < num.length(); i++) {
            s2 += num.charAt(i);
        }

        if (s1.equals(s2)) return false;
        else return divideconquer(s1) && divideconquer(s2);
    }
}
