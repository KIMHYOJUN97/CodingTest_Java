package baekjoon.Week2_DataStructure;

import java.util.*;
import java.io.*;

public class 나는야포켓몬마스터_1620 {
    public static boolean isNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> hashMap = new HashMap<>();
        Map<Integer, String> hashMap2 = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            String input = br.readLine();
            hashMap.put(input, i);
            hashMap2.put(i, input);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (isNum(input)) {
                bw.write(hashMap2.get(Integer.parseInt(input)));
                bw.newLine();
            } else {
                bw.write(String.valueOf(hashMap.get(input)));
//                bw.write(hashMap.get(input));
                bw.newLine();
            }
        }
        bw.close();
    }

}
