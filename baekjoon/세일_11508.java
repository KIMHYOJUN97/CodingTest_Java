package baekjoon;

import java.util.*;
import java.io.*;

public class 세일_11508 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        Long ans = 0L;
        for(int i=0;i<N;i++){
            al.add(Integer.parseInt(br.readLine()));
        }
        al.sort(Collections.reverseOrder());
        for(int i=1;i<N+1;i++){
            if(i%3==0) continue;
            ans += al.get(i - 1);
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
