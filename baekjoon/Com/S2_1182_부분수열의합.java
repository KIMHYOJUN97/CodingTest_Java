package baekjoon.Com;

/**
 * N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * <p>
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
 * 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * <p>
 * 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 * <p>
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
 * 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * <p>
 * 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 * <p>
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
 * 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * <p>
 * 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 * <p>
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
 * 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * <p>
 * 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 * <p>
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
 * 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * <p>
 * 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 */

/**
 *첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
 *주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 */

/**
 *첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 5 0
 * -7 -3 -2 5 8
 *
 * 1
 */

// 처음 풀이는 원소를 모두 선택했다는 가정 하에만 코드가 진행되게 된다.
//public class S2_1182_부분수열의합 {
//
//    static int s, ans = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] str = br.readLine().split(" ");
//        int n = stoi(str[0]);
//        s = stoi(str[1]);
//        boolean[] visit = new boolean[n];
//        String[] nums = br.readLine().split(" ");
//        int[] numbers = new int[n];
//        for (int i = 0; i < nums.length; i++) {
//            numbers[i] = stoi(nums[i]);
//        }
//
//        dfs(visit, numbers, 0);
//
//        System.out.println(ans);
//    }
//
//    // 정렬된 수열들의 합이 s가 될 때 까지 더하거나 빼기. s보다 크면 더이상 더하지 않아도 됨(가지치기)
//    private static void dfs(boolean[] visit, int[] numbers, int sum) {
//        for (int i = 0; i < numbers.length; i++) {
//            if (!visit[i]) {
//                visit[i] = true;
//                sum += numbers[i];
//                dfs(visit, numbers, sum);
//                sum -= numbers[i];
//                visit[i] = false;
//            }
//        }
//    }
//
//    static int stoi(String s) {
//        return Integer.parseInt(s);
//    }
//}


public class S2_1182_부분수열의합 {

    static int n, s, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = stoi(str[0]);
        s = stoi(str[1]);
        String[] nums = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = stoi(nums[i]);
        }

        dfs(numbers, 0, 0);

        System.out.println(s == 0 ? ans - 1 : ans);
    }

    // 정렬된 수열들의 합이 s가 될 때 까지 더하거나 빼기. s보다 크면 더이상 더하지 않아도 됨(가지치기)
    private static void dfs(int[] numbers, int idx, int sum) {
        if (idx == n) {
            if (sum == s) ans++;
            return;
        }

        dfs(numbers, idx + 1, sum + numbers[idx]);
        dfs(numbers, idx + 1, sum);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}