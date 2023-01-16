package baekjoon.Week2_DataStructure;

import java.util.*;
import java.io.*;

public class N번째큰수_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < n-1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
