package baekjoon;

import java.util.*;
import java.io.*;

public class ATM_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        while (st.hasMoreTokens()){
            al.add(Integer.parseInt(st.nextToken()));
        }
        al.sort(Comparator.naturalOrder());
        int ans = 0;
        for(int i=0;i<N;i++){
            int sum =0;
            for(int j=0;j<=i;j++){
                sum += al.get(j);
            }
            ans += sum;
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }
}
