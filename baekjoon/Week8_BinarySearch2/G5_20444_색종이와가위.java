package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * row를 mid값이라 생각하고 풀이.
 * (row+1)*(col+1)을 한 값이 종이를 나눴을 때 나오는 개수.
 */
public class G5_20444_색종이와가위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long k = Long.parseLong(input[1]);
        long left = 0;
        long right = n;
        while (left <= right) {
            long row = (left+right)/2;
            long col = n-row;
            long cut = cutting(row,col);
            if(cut==k){
                System.out.println("YES");
                return;
            }
            else if(cut>k){
                right = row-1;
            }
            else left = row+1;
        }
        System.out.println("NO");
    }

    private static long cutting(long r, long c) {
        return (r + 1) * (c + 1);
    }
}
