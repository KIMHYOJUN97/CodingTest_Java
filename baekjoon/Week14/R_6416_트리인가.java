package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R_6416_트리인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 1;
        while (true) {
            //간선 저장하기.
            Map<Integer, Integer> map = new HashMap<>();
            String[] s = br.readLine().split(" ");
            if(s.length==2)break;
            for (int i = 0; i < s.length-2; i+=2) {
                if(stoi(s[i])==0)break;
                int a = stoi(s[i]);
                int b = stoi(s[i + 1]);

                map.put(a, map.getOrDefault(a, 0));
                map.put(b, map.getOrDefault(b, 0) + 1);
            }

            int root = 0;
            boolean flag = true;
            for (Integer integer : map.keySet()) {
                if(map.get(integer)==0)root++;
                else if (map.get(integer) > 1) {
                    flag = false;
                    break;
                }
            }

            if (map.size() == 0) {
                System.out.println("Case " + test + " is a tree.");
            } else if (flag && root == 1 && s.length - 2 == map.size() - 1) {
                System.out.println("Case " + test + " is a tree.");
            }else{
                System.out.println("Case " + test + " is a not tree.");
            }

            test++;

        }
    }

//    static int find(int a, int[] parent) {
//        if(a!=parent[a]) parent[a] = find(parent[a],parent);
//        return parent[a];
//    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
