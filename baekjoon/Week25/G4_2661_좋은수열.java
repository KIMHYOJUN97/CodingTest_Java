package baekjoon.Week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_2661_좋은수열 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs("");
    }

    private static void dfs(String num) {
        if (num.length() == n) {
            System.out.println(num);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (check(num + i)) {
                dfs(num + i);
            }
        }
    }

    private static boolean check(String num) {
        int length = num.length() / 2;

        for (int i = 1; i <= length; i++) {
            String front = num.substring(num.length() - i * 2, num.length() - i);
            String back = num.substring(num.length() - i, num.length());
            if(front.equals(back)) return false;
        }

        return true;
    }
}
