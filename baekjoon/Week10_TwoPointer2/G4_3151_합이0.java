package baekjoon.Week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class G4_3151_합이0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] students = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(students);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if(students[i]>0)break;
            int num = students[i];
            int start = i+1;
            int end = n-1;

            while (start < end) {
                int sum = num + students[start] + students[end];

                if (sum == 0) {
                    int s = 1;
                    int e = 1;
                    if (students[start] == students[end]) {
                        ans += combi(end - start + 1);
                        break;
                    }

                    while (students[start] == students[start + 1]) {
                        s++;
                        start++;
                    }

                    while (students[end] == students[end - 1]) {
                        e++;
                        end--;
                    }

                    ans += s*e;
                }
                if(sum>0)end--;
                else start++;
            }
        }
        System.out.println(ans);
    }

    private static long combi(int n) {
        return n*(n-1)/2;
    }
}
//public class G4_3151_합이0 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] students = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            students[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(students);
//        int start=0,end=n-1;
//        int cnt = 0;
//
//        while (start < end) {
//            int sum = students[start]+students[end];
//            int flag = 0;
//            for (int i = start + 1; i < end; i++) {
//                if(sum+students[i]==0) {
//                    cnt++;
//                    System.out.println(students[start]+" "+students[i]+" "+students[end]);
//                }
//                if(sum+students[i]>0)flag=1;
//            }
//            if(flag==1)end--;
//            else start++;
//        }
//        System.out.println(cnt);
//    }
//}
