package baekjoon;

import java.util.*;
import java.io.*;

public class 서강근육맨_20300 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Long> al = new ArrayList<>();
        Long ans = 0L;

        for(int i=0;i<N;i++){
            al.add(Long.parseLong(st.nextToken()));
        }
        al.sort(Comparator.naturalOrder());
        if(al.size()%2==0){
            for(int i=0;i<al.size()/2;i++){
                ans = Math.max(ans, al.get(i) + al.get(al.size() - 1 - i));
            }
        }
        else{
            for(int i=0;i<al.size()/2;i++){
                ans = Math.max(ans, al.get(i) + al.get(al.size() - 2 - i));
            }
            ans = Math.max(ans, al.get(al.size() - 1));
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }
}
