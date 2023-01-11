package baekjoon;

import java.util.*;
import java.io.*;

public class 주유소_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> distance = new ArrayList<>();
        ArrayList<Long> price = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            distance.add(Long.parseLong(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price.add(Long.parseLong(st.nextToken()));
        }
        Long ans = 0L;
        Long min = Long.MAX_VALUE;
        for(int i=0;i<N-1;i++){
            if(min>price.get(i)){
                min=price.get(i);
            }
            ans = ans + distance.get(i)*min;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//
//    public static int N;
//    public static ArrayList<Integer> length = new ArrayList<>();
//    public static ArrayList<Integer> price = new ArrayList<>();
//    public static long findMin() {
//
//        long min = price.get(0);
//        long sum = min * length.get(0);
//        for(int i = 1; i < N - 1; i++) {
//            if(min > price.get(i))
//                min = price.get(i);
//            sum += min * length.get(i);
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//
//        Scanner scan = new Scanner(System.in);
//
//        N = scan.nextInt();
//        for(int i = 0; i < N - 1; i++) {
//            length.add(scan.nextInt());
//        }
//        for(int i = 0; i < N; i++) {
//            price.add(scan.nextInt());
//        }
//        System.out.println(findMin());
//        scan.close();
//    }
