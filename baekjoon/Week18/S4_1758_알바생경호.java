package baekjoon.Week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S4_1758_알바생경호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(stoi(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i) - i > 0) {
                ans += list.get(i)-i;
            }else break;
        }
        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
