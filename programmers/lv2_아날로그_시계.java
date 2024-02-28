package programmers;

import java.io.IOException;
import java.util.List;

public class lv2_아날로그_시계 {
    public static void main(String[] args) throws IOException {

        int h1 = 12;
        int m1 = 0;
        int s1 = 0;
        int h2 = 12;
        int m2 = 1;
        int s2 = 0;

        System.out.println(solution(h1, m1, s1, h2, m2, s2));

    }

    private static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = new Time(h1, m1, s1).toSecnd();
        int end = new Time(h2, m2, s2).toSecnd();

        for (int i = start; i < end; i++) {
            List<Double> cnt = new Time(i).getDegree();
            List<Double> nxt = new Time(i + 1).getDegree();

            boolean flagHour = hourMatch(cnt, nxt);
            boolean flagMinute = minuteMatch(cnt, nxt);

            if (flagHour && flagMinute) {
                if (Double.compare(nxt.get(0), nxt.get(1)) == 0) answer++;
                else answer += 2;
            } else if (flagHour || flagMinute) answer++;
        }

        // 0초, 12시일 때
        if (start == 0 || start == 43200) answer++;

        return answer;
    }

    static boolean hourMatch(List<Double> cnt, List<Double> nxt) {
        if (Double.compare(cnt.get(0), cnt.get(2)) > 0 && Double.compare(nxt.get(0), nxt.get(2)) <= 0) {
            return true;
        }

        if (Double.compare(cnt.get(2), 354d) == 0 && Double.compare(cnt.get(0), 354d) > 0) return true;

        return false;
    }

    static boolean minuteMatch(List<Double> cnt, List<Double> nxt) {
        if (Double.compare(cnt.get(1), cnt.get(2)) > 0 && Double.compare(nxt.get(1), nxt.get(2)) <= 0) {
            return true;
        }

        if (Double.compare(cnt.get(2), 354d) == 0 && Double.compare(cnt.get(1), 354d) > 0) return true;

        return false;
    }

    static class Time {
        int hour;
        int minute;
        int second;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        Time(int seconds) {
            this.hour = seconds / 3600;
            this.minute = (seconds % 3600) / 60;
            this.second = seconds % 60;
        }

        int toSecnd() {
            return hour * 3600 + minute * 60 + second;
        }

        List<Double> getDegree() {
            return List.of(
                    (hour % 12 + minute / 60.0) * 30,
                    minute * 6.0,
                    second * 6.0);
        }
    }


}
