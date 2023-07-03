package programmers;

import java.util.*;
public class lv2_괄호회전하기 {
    public static void main(String[] args) {
        String s = "[](){}";
        int answer = 0;
        int x = s.length();
        for(int i=0;i<x;i++){
            Stack<Character> st = new Stack<>();
            boolean flag = true;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==']'){
                    if(st.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(st.pop()!='['){
                        flag = false;
                        break;
                    }
                }else if(s.charAt(j)=='}'){
                    if(st.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(st.pop()!='{'){
                        flag = false;
                        break;
                    }
                }else if(s.charAt(j)==')'){
                    if(st.isEmpty()){
                        flag = false;
                        break;
                    }
                    if(st.pop()!='('){
                        flag = false;
                        break;
                    }
                }else{
                    st.push(s.charAt(j));
                }
            }

            if(flag && st.isEmpty())answer++;
            String new_s = "";
            for(int j=1;j<s.length();j++){
                new_s += String.valueOf(s.charAt(j));
            }
            new_s += String.valueOf(s.charAt(0));
            s = new_s;
        }
        System.out.println(answer);
    }

}
