package baekjoon.Week2_DataStructure;

import java.util.*;
import java.io.*;

public class 최대힙_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int req = Integer.parseInt(br.readLine());
            if (req == 0) {
                if (priorityQueue.isEmpty()) {
                    bw.write(String.valueOf(0));
                    bw.newLine();
                }
                else {
                    bw.write(String.valueOf(-priorityQueue.poll()));
                    bw.newLine();
                }
            }
            else{
                priorityQueue.add(-req);
            }
        }
        bw.close();
    }
}
