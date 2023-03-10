package baekjoon.Week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_22862_가장긴짝수연속한부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int cnt = 0;
        int ans = 0;
        int cut = 0;
        int prev = -1;
        while (end < n) {
            if(numbers[end]%2==1){
                if(prev!=end)
                    cut++;
                if(k-cut>=0)end++;
                else{
                    prev = end;
                    if(numbers[start]%2==1){
                        cut--;
                    }
                    else{
                        cnt--;
                    }
                    start++;
                }
            }
            else{
                cnt++;
                end++;
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
