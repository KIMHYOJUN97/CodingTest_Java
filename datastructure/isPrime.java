package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class isPrime {

    //n까지 소수 구하기
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        prime = new boolean[n+1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if(!prime[i]){
                for(int j=i*i;j<=n;j+=i)prime[j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if(!prime[i]) System.out.print(i+" ");
        }
    }
}
