package baekjoon.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_11728_배열합치기_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<2;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                list.add(stoi(st.nextToken()));
            }
        }

        Collections.sort(list);
        for(int x: list){
            System.out.print(x+" ");
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
