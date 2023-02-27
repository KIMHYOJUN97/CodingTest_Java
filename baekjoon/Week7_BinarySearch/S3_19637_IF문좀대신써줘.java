package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_19637_IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] names = new String[n];
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            names[i] = inputs[0];
            score[i] = Integer.parseInt(inputs[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int req = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n-1;
            while (start <= end) {
                int mid = (start+end)/2;
                if(score[mid]<req)start = mid+1;
                else end = mid-1;
            }
            sb.append(names[start]+"\n");
        }
        System.out.println(sb);
    }
}
