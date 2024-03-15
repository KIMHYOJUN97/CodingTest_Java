package baekjoon.Com;

/**
 * 초기에
 * $n+1$개의 집합
 * $\{0\}, \{1\}, \{2\}, ... , \{n\}$이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 * <p>
 * 집합을 표현하는 프로그램을 작성하시오.
 * <p>
 * <p>
 * 첫째 줄에
 * $n$,
 * $m$이 주어진다.
 * $m$은 입력으로 주어지는 연산의 개수이다. 다음
 * $m$개의 줄에는 각각의 연산이 주어진다. 합집합은
 * $0$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$가 포함되어 있는 집합과,
 * $b$가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은
 * $1$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$와
 * $b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 * <p>
 * 1로 시작하는 입력에 대해서
 * $a$와
 * $b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
 * <p>
 * <p>
 * 첫째 줄에
 * $n$,
 * $m$이 주어진다.
 * $m$은 입력으로 주어지는 연산의 개수이다. 다음
 * $m$개의 줄에는 각각의 연산이 주어진다. 합집합은
 * $0$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$가 포함되어 있는 집합과,
 * $b$가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은
 * $1$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$와
 * $b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 * <p>
 * 1로 시작하는 입력에 대해서
 * $a$와
 * $b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
 * <p>
 * <p>
 * 첫째 줄에
 * $n$,
 * $m$이 주어진다.
 * $m$은 입력으로 주어지는 연산의 개수이다. 다음
 * $m$개의 줄에는 각각의 연산이 주어진다. 합집합은
 * $0$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$가 포함되어 있는 집합과,
 * $b$가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은
 * $1$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$와
 * $b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 * <p>
 * 1로 시작하는 입력에 대해서
 * $a$와
 * $b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
 * <p>
 * <p>
 * 첫째 줄에
 * $n$,
 * $m$이 주어진다.
 * $m$은 입력으로 주어지는 연산의 개수이다. 다음
 * $m$개의 줄에는 각각의 연산이 주어진다. 합집합은
 * $0$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$가 포함되어 있는 집합과,
 * $b$가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은
 * $1$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$와
 * $b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 * <p>
 * 1로 시작하는 입력에 대해서
 * $a$와
 * $b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
 */


/**
 *
 *첫째 줄에
 * $n$,
 * $m$이 주어진다.
 * $m$은 입력으로 주어지는 연산의 개수이다. 다음
 * $m$개의 줄에는 각각의 연산이 주어진다. 합집합은
 * $0$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$가 포함되어 있는 집합과,
 * $b$가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은
 * $1$
 * $a$
 * $b$의 형태로 입력이 주어진다. 이는
 * $a$와
 * $b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 */

/**
 *1로 시작하는 입력에 대해서
 * $a$와
 * $b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 7 8
 0 1 3
 1 1 7
 0 7 6
 1 7 1
 0 3 7
 0 4 2
 0 1 1
 1 1 1
 *
 * NO
 * NO
 * YES
 */
public class G5_1717_집합의표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);

        StringBuilder sb = new StringBuilder();

        int[] parent = new int[n + 1];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int k = stoi(s[0]);
            int a = stoi(s[1]);
            int b = stoi(s[2]);

            if (k == 0) {
                union(a, b, parent);
            } else {
                sb.append(find(a, parent) == find(b, parent) ? "YES" : "NO");
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int find(int a, int[] parent) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a], parent);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
