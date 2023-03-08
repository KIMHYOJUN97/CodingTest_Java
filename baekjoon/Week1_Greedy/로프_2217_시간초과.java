package baekjoon.Week1_Greedy;

import java.util.*;
import java.io.*;

public class 로프_2217_시간초과 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> Array = new ArrayList<>();
        int ans = 0;
        for(int i=0;i<N;i++){
            Array.add(Integer.parseInt(br.readLine()));
        }
        Array.sort(Comparator.naturalOrder());
//        ans = Math.max(ans, Collections.min(Array) * (i + 1));
        for(int i=N-1;i>=0;i--){
            int min=10000;
            int cnt =0;
            for(int j=N-1;j>=i;j--){
                min = Math.min(min, Array.get(j));
                cnt += 1;
            }
            ans = Math.max(ans,min*cnt);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
