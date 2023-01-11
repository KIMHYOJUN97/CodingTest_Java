package baekjoon;

import java.util.*;
import java.io.*;

public class 강의실_배정_11000 {
    //    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(br.readLine());
//
//        int[][] major = new int[n][2];
//        StringTokenizer st;
////        int min = (int) 1e9;
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            major[i][0] = Integer.parseInt(st.nextToken());
//            major[i][1] = Integer.parseInt(st.nextToken());
////            min = Math.min(major[i][0], min);
//            max = Math.max(major[i][1], max);
//        }
//        Arrays.sort(major, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                } else {
//                    return o1[1] - o2[0];
//                }
//            }
//        });
//        int[] visited = new int[max];
//        for (int i = 0; i < max; i++) {
//            visited[i] = 0;
//        }
//
//        int ans = 0;
//
//        for (int[] m : major) {
//            int flag = 0;
//            for(int i=m[0];i<m[1];i++){
//                if(visited[i]==0)visited[i]=1;
//                else flag=1;
//            }
//            if(flag==1) ans++;
//        }
//
//        bw.write(String.valueOf(ans));
//        bw.close();
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] major = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            major[i][0] = Integer.parseInt(st.nextToken());
            major[i][1] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(major, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                } else {
//                    return o1[1] - o2[0];
//                }
//            }
//        });
        Arrays.sort(major,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        pq.add(major[0][1]);
        for (int i = 1; i < n; i++) {
            if (major[i][0] < pq.peek()) pq.add(major[i][1]);
            else{
                pq.poll();
                pq.add(major[i][1]);
            }
        }
        bw.write(String.valueOf(pq.size()));
        bw.close();
    }
}
