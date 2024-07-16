package programmers;

import java.util.*;

public class _대충만든자판 {

    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            Map<String, Integer> map = new HashMap<>();
            for(int i=0;i<keymap.length;i++){
                String[] keys = keymap[i].split("");
                for(int j=0;j<keys.length;j++){
                    int minNumber = 0;
                    if(map.getOrDefault(keys[j], 100) > j+1){
                        minNumber = j+1;
                    }else{
                        minNumber = map.get(keys[j]);
                    }
                    map.put(keys[j], minNumber);
                }
            }

            for(int i=0;i<targets.length;i++){
                int cnt = 0;
                String[] target = targets[i].split("");
                try{
                    for(int j=0;j<target.length;j++){
                        cnt += map.get(target[j]);
                    }
                }catch(Exception e){
                    answer[i] = -1;
                }

                answer[i] = cnt;
            }
            return answer;
        }
    }
}
