package baekjoon.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_14916_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        System.out.println(dfs(n/5,n));
    }

    //n은 5로 나눌 갯수
    static int dfs(int n, int m){
        //13 % 5 = 3 ->나머지원
        if(n == -1)return -1;
        int com = (m-n*5)%2;
        if(com==0)return n+(m-n*5)/2;
        else{
            return dfs(n-1,m);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
