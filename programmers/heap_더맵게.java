package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class heap_더맵게 {
    public static void main(String[] args) {
        int[] scovile = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scovile, K));
    }

    private static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;

        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.size() > 1) {
            int fir = pq.poll();
            int sec = pq.poll();
            if (fir >= K) return answer;
            answer++;
            pq.add(fir + sec * 2);
        }

        return pq.poll() >= K ? answer : -1;
    }
}
