package baekjoon.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//중복 조합.
public class S5_18511_큰수구성하기_완전탐색 {
    static List<Integer> ans = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = stoi(s[0]);
        int k = stoi(s[1]);
        String[] numbers = br.readLine().split(" ");

        dfs("", k, numbers, 0);
        //dfs로 하나씩 넣고 빼보면서 수 구성해보기
        Collections.sort(ans, Collections.reverseOrder());
        System.out.println(ans.get(0));
    }

    static void dfs(String num,int k,String[] numbers,int cnt) {
        if(num != "" && stoi(num)>n){
            return;
        } else if (num != "" && stoi(num) <= n) {
            ans.add(stoi(num));
        }

        for (int i = 0; i < k; i++) {
            num += numbers[i];
            dfs(num, k, numbers, cnt+1);
            String copy= "";
            for (int j = 0; j < num.length()-1; j++) {
                copy += num.charAt(j);
            }
            num = copy;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
