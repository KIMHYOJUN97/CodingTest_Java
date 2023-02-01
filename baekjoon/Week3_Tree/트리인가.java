package baekjoon.Week3_Tree;

import java.util.*;
import java.io.*;

public class 트리인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = 1;

        while (true) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int edge = 0;
            while (true) {
                int flag = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                if(st.equals("")||st.equals(null)) break;
                ArrayList<Integer> al = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    al.add(Integer.parseInt(st.nextToken()));
                }
                for (Integer x : al) {
                    if(x==0){
                        flag=1;
                        break;
                    }

                }
                if(flag==1)break;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
        }
    }
}
