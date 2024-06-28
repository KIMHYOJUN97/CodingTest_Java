package programmers;

public class lv2_혼자서_하는_틱택토 {
    class Solution {
        public int solution(String[] board) {
            int answer = 1;

            if (checkFirstCondition(board)) return 0;
            if (checkSecondCondition(board)) return 0;

            return answer;
        }

        boolean checkFirstCondition(String[] board) {
            int oCnt = 0;
            int xCnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i].charAt(j) == 'O') oCnt++;
                    if (board[i].charAt(j) == 'X') xCnt++;
                }
            }

            if (Math.abs(oCnt - xCnt) > 1) return true;
            if (oCnt < xCnt) return true;

            return false;
        }

        boolean checkSecondCondition(String[] board) {
            boolean oFlag = false;
            boolean xFlag = false;
            // 가로
            for (int i = 0; i < 3; i++) {
                int oCnt = 0;
                int xCnt = 0;
                for (int j = 0; j < 3; j++) {
                    if (board[i].charAt(j) == 'O') oCnt++;
                    if (board[i].charAt(j) == 'X') xCnt++;
                }
                if (oCnt == 3) oFlag = true;
                if (xCnt == 3) xFlag = true;

                if (oFlag && xFlag) return true;
                if (!oFlag && xFlag) {
                    if (checkThird(board)) return true;
                }
            }

            oFlag = false;
            xFlag = false;
            // 세로
            for (int i = 0; i < 3; i++) {
                int oCnt = 0;
                int xCnt = 0;
                for (int j = 0; j < 3; j++) {
                    if (board[j].charAt(i) == 'O') oCnt++;
                    if (board[j].charAt(i) == 'X') xCnt++;
                }
                if (oCnt == 3) oFlag = true;
                if (xCnt == 3) xFlag = true;
                if (oFlag && xFlag) return true;
                if (!oFlag && xFlag) {
                    if (checkThird(board)) return true;
                }
            }

            // 대각선 오른쪽에서 왼쪽

            int oCnt = 0;
            int xCnt = 0;
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(i) == 'O') oCnt++;
                if (board[i].charAt(i) == 'X') xCnt++;
            }
            if (oCnt == 3) {
                if (checkFourth(board)) return true;
            } else if (xCnt == 3) {
                if (checkThird(board)) return true;
            }

            oCnt = 0;
            xCnt = 0;

            // 대각선 왼쪽에서 오른쪽
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(2 - i) == 'O') oCnt++;
                if (board[i].charAt(2 - i) == 'X') xCnt++;
            }

            if (oCnt == 3) {
                if (checkFourth(board)) return true;
            } else if (xCnt == 3) {
                if (checkThird(board)) return true;
            }
            return false;
        }

        boolean checkThird(String[] board) {
            int oCnt = 0;
            int xCnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i].charAt(j) == 'O') oCnt++;
                    if (board[i].charAt(j) == 'X') xCnt++;
                }
            }

            if (oCnt > xCnt) return true;
            return false;
        }

        boolean checkFourth(String[] board) {
            int oCnt = 0;
            int xCnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i].charAt(j) == 'O') oCnt++;
                    if (board[i].charAt(j) == 'X') xCnt++;
                }
            }

            if (oCnt <= xCnt) return true;
            return false;
        }
    }
}
