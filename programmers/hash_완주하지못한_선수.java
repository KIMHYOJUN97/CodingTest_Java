package programmers;

import java.util.HashMap;
import java.util.Map;

public class hash_완주하지못한_선수 {

    public static void main(String[] args) {


    }

    // 공간 효율성 생각하기!
    private String solution(String[] participant, String[] completion) {
        Map<String, Integer> runner = new HashMap<>();
        for (String s : participant) {
            runner.put(s, runner.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            runner.put(s, runner.get(s)-1);
        }

        for (String s : runner.keySet()) {
            if (runner.get(s)!=0) return s;
        }

        return "";
    }
}
