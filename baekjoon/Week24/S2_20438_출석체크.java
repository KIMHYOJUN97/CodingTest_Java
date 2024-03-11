package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S2_20438_출석체크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);
        int q = stoi(s[2]);
        int m = stoi(s[3]);
        StringBuilder sb = new StringBuilder();

        int[] students = new int[n + 4];
        int[] sum = new int[n + 4];
        Map<Integer, Integer> sleepStudent = new HashMap<>();
        List<int[]> scopeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            scopeList.add(new int[2]);
        }

        for (int i = 0; i <= n+3; i++) {
            students[i] = 1;
        }

        s = br.readLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            sleepStudent.put(stoi(s[i]), 1);
        }

        s = br.readLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            int calledStudent = stoi(s[i]);
            if(sleepStudent.getOrDefault(calledStudent,0) == 1)continue;
            int plusNumber = calledStudent;
            while (plusNumber <= n+3) {
                if (sleepStudent.getOrDefault(plusNumber, 0) == 1) {
                    plusNumber += calledStudent;
                    continue;
                }
                students[plusNumber] = 0;
                plusNumber += calledStudent;
            }
        }

        for (int i = 3; i <= n + 3; i++) {
            sum[i] = sum[i - 1] + students[i];
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            sb.append(sum[stoi(s[1])] - sum[stoi(s[0])-1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
