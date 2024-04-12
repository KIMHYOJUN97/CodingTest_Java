package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 *
 * 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
 *
 * 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
 *
 * 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
 *
 * 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 *
 * 5 3
 * 1 2 3 1 2
 *
 * 7
 */
public class G3_10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = stoi(s[0]);
        int m = stoi(s[1]);
        int[] arr = new int[n];
        int[] presum = new int[n];
        s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = stoi(s[i]);
            presum[i] = i==0 ? arr[i] : presum[i-1] + arr[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long answer = 0;
        for(int i=0; i<n; i++) {
            int key = presum[i] % m;
            int value = map.getOrDefault(key, 0);
            answer += value;
            map.put(key, value + 1);
        }

        System.out.println(answer);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
