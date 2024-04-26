package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 문제
 세 수 x, y, z가 x+y>z, x+z>y, y+z>x의 관계를 만족하면, 세 수는 삼각관계에 있다고 한다.

 마찬가지로 길이가 N인 수열 B(b[0], b[1], ..., b[n-1])의 모든 b[i], b[j], b[k]가 삼각관계에 있으면 이 수열은 삼각 수열이라고 한다. 이때, i, j, k는 모두 다른 값이다.

 수열 A가 주어졌을 때, 이 수열에서 적절히 몇 개의 원소를 빼서 이 수열을 삼각 수열로 만들려고 한다. 삼각 수열의 최대 길이를 구하는 프로그램을 작성하시오.

 첫째 줄에 수열의 크기 N이 주어진다. 둘째 줄에 수열 A에 들어있는 수가 공백을 사이에 두고 주어진다. N은 최대 50이고, A에 들어있는 수는 109보다 작거나 같은 자연수이다.


 첫째 줄에 가장 긴 부분 삼각 수열의 길이를 출력한다.

 3
 1 2 3

 2

 7
 2 3 4 1 3 4 5

 5

 8
 1 1 1 1 1 1 1 1

 8

 6
 1 1 1 1000000000 1000000000 1000000000

 4

 1
 1000000000

 1
 */

/**
 * 풀이: 정렬된 수열에서 가장 작은 두 수(a,b)의 합이 가장 큰 수(c)보다 크면 b와 c 사이의 수는 삼각 수열을 만족한다.
 */
public class G5_1548_부분삼각수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(s[i]);
        }
        Arrays.sort(arr);

        int answer = Math.min(2,n);
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
                        answer = Math.max(answer, k - j + 2);
                    }
                }
            }
        }

        System.out.println(answer);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
