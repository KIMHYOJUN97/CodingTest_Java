package baekjoon.Com;

public class lv1_바탕화면정리 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];
            int minX = 50, minY = 50, maxX = -1, maxY = -1;
            for (int i = 0; i < wallpaper.length; i++) {
                String[] wall = wallpaper[i].split("");
                for (int j = 0; j < wall.length; j++) {
                    if (wall[j].equals("#")) {
                        if (i < minY) minY = i;
                        if (i > maxY) maxY = i;
                        if (j < minX) minX = j;
                        if (j > maxX) maxX = j;
                    }
                }
            }

            answer[0] = minY;
            answer[1] = minX;
            answer[2] = maxY;
            answer[3] = maxX;
            return answer;
        }
    }
}
