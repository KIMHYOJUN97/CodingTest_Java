package baekjoon.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_20546_기적의매매법_구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = stoi(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] machine = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            machine[i] = stoi(s[i]);
        }

        int j_money = money;
        int j_cnt = 0;
        int s_money = money;
        int s_cnt = 0;
        for (int i = 0; i < machine.length; i++) {
            if (j_money >= machine[i]) {
                int buy = j_money / machine[i];
                j_money-= machine[i]*buy;
                j_cnt += buy;
            }
        }
        j_money += j_cnt*machine[13];

        int up = 0;
        int down = 0;
        for (int i = 1; i < machine.length; i++) {
            if (machine[i] > machine[i - 1]) {
                up++;
                down = 0;
            } else if (machine[i] < machine[i - 1]) {
                up =0;
                down++;
            }else{
                up =0;
                down = 0;
            }

            if(up==3){
                s_money += s_cnt * machine[i];
                s_cnt = 0;
            } else if (down == 3) {
                int buy = s_money / machine[i];
                s_money -= buy * machine[i];
                s_cnt += buy;
            }
        }
        if (s_cnt > 0) {
            s_money += s_cnt*machine[13];
        }
        if(s_money==j_money) System.out.println("SAMESAME");
        else if(s_money>j_money) System.out.println("TIMING");
        else System.out.println("BNP");
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
