package baekjoon.Week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class G3_20366_같이눈사람만들래 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] sm = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sm[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(sm);
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sm1 = sm[i] + sm[j];
                int start = 0;
                int end = n-1;
                while (start < end) {
                    if (start == i || start == j) {
                        start++;
                        continue;
                    }
                    if (end == i || end == j) {
                        end--;
                        continue;
                    }
                    long sm2 = sm[start] + sm[end];
                    ans = Math.min(ans, Math.abs(sm1 - sm2));
                    if(sm1>sm2) start++;
                    else if (sm1 < sm2) {
                        end--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
//public class G3_20366_같이눈사람만들래 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        long[] sm = new long[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            sm[i] = Long.parseLong(st.nextToken());
//        }
//        Arrays.sort(sm);
//        int start = 0;
//        int end = n-1;
//        long ans = Long.MAX_VALUE;
//        while (start < end) {
//            int s = end-1;
//            int e = start+1;
//            long s_s = 0;
//            long s_e = 0;
//            while (e < s) {
//                long sum_s = sm[start]+sm[s];
//                long sum_e = sm[end]+sm[e];
//                ans = Math.min(ans, Math.abs(sum_e - sum_s));
//                if (sum_e > sum_s) {
//                    s_s = sum_s;
//                    s_e = sum_e;
//                    break;
//                }
//                else{
//                    e++;
//                }
//            }
//            if(s_s<s_e)end--;
//            else start++;
//
//        }
//        System.out.println(ans);
//    }
//}
