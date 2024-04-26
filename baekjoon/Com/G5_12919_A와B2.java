package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수빈이는 A와 B로만 이루어진 영어 단어 존재한다는 사실에 놀랐다.
 * 대표적인 예로 AB (Abdominal의 약자), BAA (양의 울음 소리), AA (용암의 종류), ABBA (스웨덴 팝 그룹)이 있다.
 * <p>
 * 이런 사실에 놀란 수빈이는 간단한 게임을 만들기로 했다.
 * 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임이다. 문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능하다.
 * <p>
 * 문자열의 뒤에 A를 추가한다.
 * 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
 * 주어진 조건을 이용해서 S를 T로 만들 수 있는지 없는지 알아내는 프로그램을 작성하시오.
 * <p>
 * 첫째 줄에 S가 둘째 줄에 T가 주어진다. (1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이)
 * <p>
 * S를 T로 바꿀 수 있으면 1을 없으면 0을 출력한다.
 * <p>
 * A
 * BABA
 * <p>
 * 1
 * <p>
 * BAAAAABAA
 * BAABAAAAAB
 * <p>
 * 1
 * <p>
 * A
 * ABBA
 * <p>
 * 0
 */
public class G5_12919_A와B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        backtracking(s, t);
        System.out.println(0);
    }

    static void backtracking(String s, String target) {
        if (s.length() == target.length()) {
            if (s.equals(target)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        backtracking(s + "A", target);
        backtracking(reverse(s + "B"), target);
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
