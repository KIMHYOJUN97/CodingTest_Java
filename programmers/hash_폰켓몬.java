package programmers;

import java.util.HashMap;
import java.util.Map;

public class hash_폰켓몬 {
    public static void main(String[] args) {

    }

    private int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }

        answer = map.size() > nums.length/2 ? nums.length/2 : map.size();

        return answer;
    }
}
