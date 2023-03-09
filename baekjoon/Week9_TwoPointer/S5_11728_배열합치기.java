package baekjoon.Week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int p1 = 0,p2 = 0;
        for (int i = 0; i < n + m; i++) {
            if(p1==n){
                sb.append(b[p2]+" ");
                p2++;
                continue;
            }
            if(p2==m){
                sb.append(a[p1]+" ");
                p1++;
                continue;
            }
            if(a[p1]<b[p2]){sb.append(a[p1]+" ");p1++;}
            else{
                sb.append(b[p2]+" ");p2++;
            }
        }
        System.out.println(sb);
    }
}
