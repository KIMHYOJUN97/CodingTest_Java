package baekjoon.Week1_Greedy;
import java.util.*;
import java.io.*;

/**
 * ans의 값의 범위를 정확히 인지하자
 * 100000*100000=>1억이 넘는다 =Long으로 표현
 */
public class 알바생강호_1758 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Long ans = 0L;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            al.add(Integer.parseInt(br.readLine()));
        }
        al.sort(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            if(al.get(i)-i>0) ans += (al.get(i) - i);
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }
}
