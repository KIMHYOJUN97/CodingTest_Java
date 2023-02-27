package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long s = Long.parseLong(br.readLine());
        double n = ((Math.sqrt(1+8*s)-1)/2);
        System.out.println(Math.round(Math.floor(n)));
    }
}
