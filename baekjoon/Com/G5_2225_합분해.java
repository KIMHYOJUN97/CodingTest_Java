package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20 2
// 21

//6 4
//
public class G5_2225_합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
