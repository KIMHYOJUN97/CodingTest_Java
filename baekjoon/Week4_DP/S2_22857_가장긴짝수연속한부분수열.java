package baekjoon.Week4_DP;

import java.util.*;
import java.io.*;

public class S2_22857_가장긴짝수연속한부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] S = new int[s];
        for (int i = 0; i < s; i++) {
            S[i] = Integer.parseInt(input[i]);
        }

    }
    //100 5
   //1 2 3 4 5 5 7 9 ... 100
    //(N+1)N/2
}
