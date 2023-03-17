package baekjoon.Week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_22945_팀빌딩 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        int[] developer = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            developer[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;

        while(start<end){
            ans = Math.max((end-start-1)*Math.min(developer[start],developer[end]),ans);
            if(developer[start]<developer[end])start++;
            else end--;
        }
        System.out.println(ans);

    }
}
