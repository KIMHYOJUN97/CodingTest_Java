package baekjoon.Week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_9663_NQueen {
    static int n,count = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //세로축을 담당하는 visit
        arr = new int[n];
        dfs(0);
        System.out.println(count);

    }

    //가로 세로 대각선 겹치면 안됨.
    static void dfs(int idx) {
        if (idx == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[idx] = i;
            if(check(idx)) dfs(idx + 1);
        }
    }

    static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if(arr[col] == arr[i])return false;
            else if(Math.abs(col - i) == Math.abs(arr[col]-arr[i]))return false;
        }

        return true;
    }
}
