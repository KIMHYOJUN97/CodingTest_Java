package baekjoon.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_21921_블로그_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int x = stoi(s[1]);
        s = br.readLine().split(" ");
        int[] visitor = new int[n];
        for(int i=0;i<n;i++){
            visitor[i] = stoi(s[i]);
        }
        int lt = 0;
        int rt = x-1;
        for(int i=lt;i<x;i++){
            max += visitor[i];
        }
        lt++;
        rt++;
        int day = 0;
        while (rt < n) {
            if(max <max-visitor[lt-1]+visitor[rt]){
                max = max-visitor[lt-1]+visitor[rt];
                day = 1;
            } else if (max == (max - visitor[lt - 1] + visitor[rt])) {
                day++;
            }
            lt++;
            rt++;
        }
        if(max==0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(day);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
