package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_15721_번데기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int flag = Integer.parseInt(br.readLine());
        List<Integer> members = new ArrayList<>();
        int cnt = 2;
        while (members.size()<10000) {
            members.add(0);
            members.add(1);
            members.add(0);
            members.add(1);
            for (int i = 0; i < cnt; i++) {
                members.add(0);
            }
            for (int i = 0; i < cnt; i++) {
                members.add(1);
            }
            cnt++;
            //o x o x o o x x
            //o x o x o o o x x x
            //init n = 2
            //4 + n*2

        }
        int cnt2 = 0;
        int ans=0;
        for (int i = 0; i < members.size(); i++) {
            if(members.get(i)==flag)cnt2++;
            if(cnt2==t) {
                ans = i;
                break;
            };
        }
        System.out.println(ans%n);
    }
}
