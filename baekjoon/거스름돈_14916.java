package baekjoon;

import java.util.*;
import java.io.*;

public class 거스름돈_14916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int coin_5 =n/5;
        int coin_2 = 0;

        while(true){
            if(coin_5==-1){
                bw.write(String.valueOf(-1));
                bw.close();
                return;
            }
            if((n-5*coin_5)%2==0){
                coin_2=(n-5*coin_5)/2;
                break;
            }
            else{
                coin_5--;
            }
        }
        bw.write(String.valueOf(coin_2+coin_5));
        bw.close();
    }
}
