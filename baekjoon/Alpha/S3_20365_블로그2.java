package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1개로 다 밀고 나머지를 채우는 수
 * vs
 * 차근차근 하나씩 색칠해가는 수 비교
 * 뭉친경우
 */

/**
 * 전부 같은 색으로 칠해 놓음(R or B)
 * 그 다음 뭉쳐보기
 */
public class S3_20365_블로그2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 1,cnt2=1;
        boolean flag = false;
        //blue
        for (int i = 0; i < s.length(); i++) {
            if(flag ==true){
                if(s.charAt(i)=='B') flag=false;
                else continue;
            }
            if(s.charAt(i)=='R' && flag==false){
                flag = true;
                cnt++;
            }
        }

        flag = false;
        //red
        for (int i = 0; i < s.length(); i++) {
            if(flag ==true){
                if(s.charAt(i)=='R') flag=false;
                else continue;
            }
            if(s.charAt(i)=='B' && flag==false){
                flag = true;
                cnt2++;
            }
        }

        System.out.println(Math.min(cnt,cnt2));

    }
}
