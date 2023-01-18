package baekjoon.Week2_DataStructure;

import java.util.*;
import java.io.*;

public class 중앙값구하기_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            int cnt = 0;
            if(M%2==1) sb.append((M / 2 + 1 )+ "\n");
            else sb.append(M / 2+"\n");

            for (int m = 0; m < M; m++) {
                if(m%10==0) st = new StringTokenizer(br.readLine());
                if (pq.size()==pq2.size()) {
                    pq.add(Integer.parseInt(st.nextToken()));
                } else pq2.add(Integer.parseInt(st.nextToken()));

                if (!pq.isEmpty() && !pq2.isEmpty()) {
                    int p_num = pq.peek();
                    int p_num2 = pq2.peek();

                    if (p_num > p_num2) {
                        pq.remove(p_num);
                        pq.add(p_num2);
                        pq2.remove(p_num2);
                        pq2.add(p_num);
                    }
                }

                if (cnt % 2 == 0) {
                    sb.append(pq.peek() + " ");
                    if(cnt==9 || !st.hasMoreTokens()) {
                        sb.append("\n");
                        cnt = 0;
                    }
                }
                cnt++;
            }

            while (st.hasMoreTokens()) {
                if (pq.size()==pq2.size()) {
                    pq.add(Integer.parseInt(st.nextToken()));
                } else pq2.add(Integer.parseInt(st.nextToken()));

                if (!pq.isEmpty() && !pq2.isEmpty()) {
                    int p_num = pq.peek();
                    int p_num2 = pq2.peek();

                    if (p_num > p_num2) {
                        pq.remove(p_num);
                        pq.add(p_num2);
                        pq2.remove(p_num2);
                        pq2.add(p_num);
                    }
                }

                if (cnt % 2 == 0) {
                    sb.append(pq.peek() + " ");
                    if(cnt==9 || !st.hasMoreTokens()) {
                        sb.append("\n");
                        cnt = 0;
                    }
                }
                cnt++;
            }




        }

        System.out.println(sb);
    }
}
