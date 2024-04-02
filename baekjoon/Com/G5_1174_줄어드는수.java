package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G5_1174_줄어드는수 {
    static List<Long> list = new ArrayList<>();

    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        backtracking(0, 0);

        Collections.sort(list);
        try {
            System.out.println(list.get(n - 1));
        } catch (Exception e) {
            System.out.println(-1);
        }
    }

    static void backtracking(long num, int idx) {
        if (!list.contains(num)) list.add(num);
        if (idx >= 10) return;

        backtracking(num * 10 + arr[idx], idx + 1);
        backtracking(num, idx + 1);
    }
}
