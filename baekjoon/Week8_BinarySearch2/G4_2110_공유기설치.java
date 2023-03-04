package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_2110_공유기설치 {
    static int[] distance;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(distance);
        int start = 1;
        int end = distance[n-1]-distance[0];
        int ans = 1;
        while (start <= end) {
            int mid = (start+end)/2;
            if(search(mid)>=c){
                start = mid+1;
                ans = mid;
            }
            else{
                end = mid-1;
            }
        }
        System.out.println(ans);
    }

    private static int search(int target) {
        int prev = 0;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if(distance[i]-distance[prev]>=target){
                cnt++;
                prev = i;
            }
        }
        return cnt;
    }
}
