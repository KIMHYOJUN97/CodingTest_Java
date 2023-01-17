package baekjoon.Week2_DataStructure;

import java.io.*;
import java.util.*;

public class 이중우선순위큐_7662 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//
//        for (int t = 0; t < T; t++) {
//            int K = Integer.parseInt(br.readLine());
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
//
//            for (int k = 0; k < K; k++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                String str = st.nextToken();
//                int n = Integer.parseInt(st.nextToken());
//                if (str.equals("I")) {
//                    pq.add(n);
//                    pq2.add(n);
//                }
//                else{
//                    //최댓값 삭제
//                    if (n == 1) {
//                        if (!pq2.isEmpty()) {
//                            pq.remove(pq2.poll());
//                        }
//                    }
//                    //최솟값 삭제
//                    else {
//                        if (!pq.isEmpty()) {
//                            pq2.remove(pq.poll());
//                        }
//                    }
//                }
//            }
//            if (pq.isEmpty()) {
//                sb.append("EMPTY\n");
//            } else {
//                sb.append(pq2.poll()).append(" ").append(pq.poll());
//            }
//        }
//        System.out.println(sb);
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int k = 0; k < K; k++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (ch == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if(map.size()==0)continue;

                    int num = n == 1 ? map.lastKey() : map.firstKey();
                    if(map.get(num)>1) map.put(num, map.get(num) - 1);
                    else map.remove(num);
                }
            }
            if(map.size()==0) System.out.println("EMPTY");
            else System.out.println(map.lastKey()+" "+map.firstKey());
        }
    }
}
