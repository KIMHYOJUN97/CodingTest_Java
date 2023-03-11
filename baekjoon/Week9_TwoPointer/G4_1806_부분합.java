package baekjoon.Week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int start=0,end=0,ans=n+1;
        int sum = numbers[0];
        while(end<n){
            if(sum<s){
                end++;
                if(end==n)break;
                sum+=numbers[end];
            }
            else{
                ans = Math.min(ans,end-start+1);
                if(start<end){
                    sum-=numbers[start++];
                }
                else{
                    if(end<n-1)
                        sum+=numbers[++end];
                    else end++;
                }
            }
        }
        if(ans==n+1) System.out.println(0);
        else System.out.println(ans);
    }
}
