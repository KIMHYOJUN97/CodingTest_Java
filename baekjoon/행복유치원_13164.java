package baekjoon;

import java.util.*;
import java.io.*;

public class 행복유치원_13164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> diff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<n-1;i++){
            diff.add(al.get(i + 1) - al.get(i));
        }
        diff.sort(Comparator.reverseOrder());
        int ans = 0;
        for (int i = k-1; i < diff.size(); i++) {
            ans += diff.get(i);
        }

        bw.write(String.valueOf(ans));
        bw.close();

    }
}
