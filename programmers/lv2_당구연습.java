package programmers;

public class lv2_당구연습 {
    public static void main(String[] args){

    }
    class Solution {
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];

            for(int i=0;i<balls.length;i++){
                int ans = Integer.MAX_VALUE;
                int t1 = balls[i][0];
                int t2 = balls[i][1];
                // up
                if(!(startX==t1 && startY < t2)){
                    ans = Math.min(ans, getDistance(startX, startY, t1, 2*n - t2));
                }

                // down
                if(!(startX==t1 && startY > t2)){
                    ans = Math.min(ans, getDistance(startX, startY, t1, t2*-1));
                }

                // left
                if(!(startY == t2 && startX > t1)){
                    ans = Math.min(ans, getDistance(startX, startY, t1*-1, t2));
                }

                // right
                if(!(startX < t1 && startY == t2)){
                    ans = Math.min(ans, getDistance(startX,startY,2*m-t1,t2));
                }
                answer[i] = ans;
            }
            return answer;
        }

        public int getDistance(int x, int y, int t1, int t2){
            return (int)Math.pow(Math.abs(x-t1),2) + (int)Math.pow(Math.abs(y-t2), 2);
        }
    }
}
