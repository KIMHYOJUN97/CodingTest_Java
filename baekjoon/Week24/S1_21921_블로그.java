package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1_21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int x = stoi(s[1]);
        String[] inputs = br.readLine().split(" ");
        int[] visitors = new int[n];
        for (int i = 0; i < n; i++) {
            visitors[i] = stoi(inputs[i]);
        }
        int answer = 0;
        int start = 0;
        int end = x;
        int max = 0;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            answer += visitors[i];
        }
        ans.add(answer);
        while (end < n) {
            max = Math.max(answer, max);
            answer -= visitors[start++];
            answer += visitors[end++];
            ans.add(answer);
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            int cnt = 0;
            for (Integer an : ans) {
                if(an == max) cnt++;
            }
            System.out.println(max);
            System.out.println(cnt);
        }
    }

    static String toString(List<Integer> answer) {
        StringBuilder sb = new StringBuilder();
        answer.forEach(e -> sb.append(e + " "));
        sb.append("\n");
        return sb.toString();
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
