package baekjoon;

import java.util.*;
import java.io.*;

public class 폴리오미노_1343 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String req = br.readLine();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<req.length();i++){
            if(req.charAt(i)=='X'){
                cnt++;
            }
            if(i==req.length()-1 || req.charAt(i)=='.'){
                if(cnt%2!=0){
                    bw.write(String.valueOf(-1));
                    bw.close();
                    return;
                }
                int a = cnt/4;
                int b = (cnt-a*4)/2;
                for(int j=0;j<a;j++){
                    sb.append("AAAA");
                }
                for(int j=0;j<b;j++){
                    sb.append("BB");
                }
                if(req.charAt(i)=='.') sb.append(".");
                cnt=0;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
