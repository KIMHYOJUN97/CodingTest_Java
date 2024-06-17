package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 세준이는 N개의 영어 단어를 이용해 길이가 M인 새로운 단어를 만들려고 한다.
 * 새로운 단어는 N개의 단어를 순서대로 이어 붙이고, 각 단어의 사이에 _을 넣어서 만든다.
 * 이렇게 만든 새로운 단어의 길이가 M이 아닌 경우 _를 추가해서 길이가 M이 되게 만들어야 한다.
 *
 * _는 단어와 단어 사이에만 추가할 수 있다. 따라서, 새로운 단어는 _으로 시작하거나, _로 끝날 수 없다.
 * 단어와 단어 사이에 있는 _의 개수는 모두 같아야 한다.
 * 모두 같게 만드는 것이 불가능한 경우 단어와 단어 사이에 있는 _의 개수의 최댓값과 최솟값의 차이는 1이 되어야 한다.
 * 새로운 단어 중 사전 순으로 가장 앞서는 단어를 구해보자.
 *
 * 첫째 줄에 N과 M이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다.
 *
 * 첫째 줄에 사전 순으로 가장 앞서는 단어를 출력한다.
 *
 * 알파벳 대문자, 소문자, 밑 줄의 순서는 'A' < 'B' < 'C' < ... < 'Z' < '_' < 'a' < 'b' < 'c' < ... < 'z' 이다.
 *
 * 2 ≤ N ≤ 10
 * 3 ≤ M ≤ 200
 * 단어는 알파벳 소문자, 대문자로만 이루어져 있다.
 * 1 ≤ 단어의 길이 ≤ 10
 * 단어 N개 길이의 합을 len이라고 했을 때, len+N-1 ≤ M을 만족한다.
 *
 * 9 50
 * A
 * quick
 * brown
 * fox
 * jumps
 * over
 * the
 * lazy
 * dog
 *
 * A___quick__brown__fox__jumps__over__the__lazy__dog
 *
 * 5 32
 * Alpha
 * Beta
 * Gamma
 * Delta
 * Epsilon
 *
 * Alpha_Beta_Gamma__Delta__Epsilon
 *
 * 4 29
 * Hello
 * world
 * John
 * said
 *
 * Hello____world___John____said
 */
public class S1_1474_밑줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            len += arr[i].length();
        }

        int cnt = (m - len) / (n - 1);
        int rest = (m - len) % (n - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            if (i != n - 1) {
                for (int j = 0; j < cnt; j++) {
                    sb.append("_");
                }
                if (rest > 0) {
                    sb.append("_");
                    rest--;
                }
            }
        }

        System.out.println(sb.toString());
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
