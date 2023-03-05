package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 공유기설치와 매우 유사한 문제이다.
 * 1번째 예시에서 70이 답인데 67이 나온다 어디서 틀린지 찾아보자.
 */
public class G4_1477_휴게소세우기 {
    static int n;
    static int m;
    static int l;
    static int[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        l = Integer.parseInt(input[2]);

        road = new int[n+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        road[n] = 0;
        road[n+1] = l;

        Arrays.sort(road);
        int start = 1;
        int end = l-2;
        int ans = l-2;
        while (start <= end) {
            int mid = (start+end)/2;
            int cnt = search(mid);
            if (cnt >= 0) {
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(ans);
    }

    private static int search(int mid) {
        int cnt = m;
        for (int i = 0; i < n+2; i++) {
            if(i<n-1){
                if(road[i+1]-road[i]>mid)cnt -= (road[i+1]-road[i])/mid;
            }
        }
        return cnt;
    }
}
