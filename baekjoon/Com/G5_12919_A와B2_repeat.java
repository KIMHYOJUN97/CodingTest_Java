package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_12919_A와B2_repeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        backtracking(t, s);
        System.out.println(0);
    }

    static void backtracking(String s, String target) {
        if (s.equals(target)) {
            System.out.println(1);
            System.exit(0);
        }else if(s.length() == target.length()){
            return;
        }

        if (s.charAt(s.length() - 1) == 'A') {
            backtracking(s.substring(0, s.length() - 1), target);
        }

        if (s.charAt(0) == 'B') {
            backtracking(reverse(s.substring(1)), target);
        }
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
