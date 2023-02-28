package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        int ans = 0;
        int start = 0;
        int end = trees[n-1];
        while (start <= end) {
            int mid = (start+end)/2;
            long sum = 0;
            for (int i = n-1; i >= 0; i--) {
                if(trees[i]-mid>0)sum+=(trees[i]-mid);
                else break;
            }
            if(sum<m)end = mid-1;
            else{
                ans = mid;
                start = mid+1;
            }
        }
        System.out.println(ans);
    }
}
