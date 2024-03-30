package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_2212_센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int k = stoi(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] sensors = new int[n];
        for (int i = 0; i < n; i++) {
            sensors[i] = stoi(s[i]);
        }

        int[] array = Arrays.stream(sensors).distinct().sorted().toArray();

        int[] minus = new int[n - 1];
        for (int i = 0; i < array.length - 1; i++) {
            minus[i] = array[i + 1] - array[i];
        }

        int[] ans = Arrays.stream(minus).sorted().toArray();
        int answer = 0;
        int idx = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                idx = i;
                break;
            }
        }
        for (int i = idx; i < array.length - k + idx; i++) {
            answer += ans[i];
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
