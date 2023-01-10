package baekjoon;

import java.util.*;
import java.io.*;

public class 에너지드링크_20115 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Double> al = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            al.add(Double.parseDouble(st.nextToken()));
        }
        al.sort(Comparator.naturalOrder());
        while(al.size()>1){
            al.set(al.size() - 1, al.get(0)*0.5 + al.get(al.size() - 1));
            al.remove(0);
        }
        double d = al.get(0);
        int i = (int)d;
        if(i==d) bw.write(String.valueOf(i));
        else bw.write(String.valueOf(d));
        bw.close();
    }
}
