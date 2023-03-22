package baekjoon.Week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class G2_20442_ㅋㅋ루ㅋㅋ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Integer> lk = new ArrayList<>();
        ArrayList<Integer> rk = new ArrayList<>();

        int kCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='K')kCnt++;
            else if(str.charAt(i)=='R') lk.add(kCnt);
        }
        kCnt=0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i)=='K')kCnt++;
            else if(str.charAt(i)=='R') rk.add(kCnt);
        }
        rk.sort(Comparator.reverseOrder());

        int left =0;
        int right = rk.size()-1;
        int max = 0;

        while (left <= right) {
            max = Math.max(max, (right - left + 1) + (2 * Math.min(lk.get(left), rk.get(right))));

            if(lk.get(left)<rk.get(right))left++;
            else right--;
        }
        System.out.println(max);
    }
}
