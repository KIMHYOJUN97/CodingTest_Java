package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2473_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] liquid = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(liquid);
        int start = 0;
        int end = n-1;
        int s_idx = 0;
        int e_idx = n-1;
        int m_idx = (start+end)/2;
        long min = liquid[start]+liquid[end]+liquid[(start+end)/2];
        /**
         * mid값이 min의 영향을 끼침.
         * start,end뿐 아니라 mid값도 탐색과정에 넣어야 함.
         *
         * 반례)
         * 7
         * 912022275 -968846127 195376182 -212509759 589371385 817446019 -59843192
         *
         * -968846127 195376182 817446019
         */
        while (start < end) {
            for(int i=start+1;i<end;i++) {
                int mid = i;
                if (Math.abs(min) > Math.abs(liquid[start] + liquid[end] + liquid[mid])) {
                    s_idx = start;
                    e_idx = end;
                    m_idx = mid;
                    min = liquid[start] + liquid[mid]+liquid[end];
                }
            }
            if(liquid[start]+liquid[end]<0)start++;
            else end--;
        }

        System.out.println(liquid[s_idx]+" "+liquid[m_idx]+" "+liquid[e_idx]);
//        int[] visit = new int[n];
//        visit[s_idx] = 1;
//        visit[e_idx] = 1;
//        int max = Integer.MAX_VALUE;
//        start = 0;
//        for (int i = 0; i < n; i++) {
//            if(Math.abs(liquid[start])<max && visit[start]==0){
//                start = i;
//                max = Math.abs(liquid[start]);
//            }
//        }
//        int[] ans = new int[3];
//        ans[0] = e_idx;
//        ans[1] = s_idx;
//        ans[2] = start;
//        Arrays.sort(ans);
//        System.out.println(liquid[ans[0]]+" "+liquid[ans[1]]+" "+liquid[ans[2]]);
    }
}
