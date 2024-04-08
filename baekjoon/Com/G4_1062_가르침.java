package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다.
 * 그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다.
 * 김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다.
 * 김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.
 * <p>
 * 남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다.
 * 남극언어에 단는 N개 밖에 없다고 어가정한다. 학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.
 */

/**
 * 첫째 줄에 단어의 개수 N과 K가 주어진다. N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0이다.
 * 둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다. 단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다. 모든 단어는 중복되지 않는다.
 * <p>
 * 첫째 줄에 김지민이 K개의 글자를 가르칠 때, 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.
 * <p>
 * 3 6
 * antarctica
 * antahellotica
 * antacartica
 * <p>
 * 2
 * <p>
 * 2 3
 * antaxxxxxxxtica
 * antarctica
 * <p>
 * 0
 * <p>
9 8
antabtica
antaxtica
antadtica
antaetica
antaftica
antagtica
antahtica
antajtica
antaktica
 * <p>
 * 3
 */
public class G4_1062_가르침 {
    static List<String> list = new ArrayList<>();
    static Character[] alpha;
    static Set<Character> set = new HashSet<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                set.add(str.charAt(j));
            }
            strings.add(str);
        }

        alpha = set.toArray(new Character[0]);
        char[] result = new char[k];
        combi(k, 0, 0, result);
        for (String s : list) {
            int cnt = 0;
            for (String str : strings) {
                String[] split = str.split("");
                boolean flag = false;
                for (String s1 : split) {
                    if (!s.contains(s1)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) cnt++;
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    static void dfs(int idx) {

    }

    static void combi(int r, int cnt, int start, char[] result) {
        if (cnt == r) {
            String s = "";
            for (char c : result) {
                s += c;
            }
            list.add(s);
            return;
        }

        for (int i = start; i < set.size(); i++) {
            result[cnt] = alpha[i];
            combi(r, cnt + 1, i + 1, result);
        }
    }
}
