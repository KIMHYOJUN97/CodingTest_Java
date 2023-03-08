package baekjoon.Week1_Greedy;

import java.util.*;
import java.io.*;

public class 동전0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        al.sort(Comparator.reverseOrder());
        while(true){
            int now = 0;
            for(int i=0;i<n;i++){
                if(k/al.get(i)>=1){
                    ans += k / al.get(i);
                    now = al.get(i);
                    break;
                }
            }
            k = k-(k/now)*now;
            if(k==0) break;
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }
}
