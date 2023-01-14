package baekjoon.Week2_DataStructure;

import java.util.*;
import java.io.*;

public class 절대값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 > o2 ? 1 : -1;
            }
            return abs1 - abs2;
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int req = Integer.parseInt(br.readLine());
            if (req == 0) {
                if (pq.isEmpty()) {
                    bw.write("0");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(pq.poll()));
                    bw.newLine();
                }
            } else {
                pq.add(req);
            }
        }
        bw.close();
    }
}
