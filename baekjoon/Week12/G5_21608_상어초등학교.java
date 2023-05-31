package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G5_21608_상어초등학교 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static Student[][] board;
    static List<Student> stu = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new Student[n][n];

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            stu.add(new Student(num, new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}));
        }

        //전체 순회하기
        for (Student student : stu) {
            step_1(student.num, student.prefer);
        }

        //만족도의 총 합 구하기.
        //만족도는 선호하는 사람의 명수를 10의 제곱으로 나타낸 것 이다.
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.pow(10, step_2(i, j, board[i][j].prefer).like - 1);
            }
        }
        System.out.println(ans);
    }

    static void step_1(int num, int[] prefer) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] !=null) continue;
                positions.add(step_2(i, j, prefer));
            }
        }
        //조건에 맞게 Comparable로 정렬
        Collections.sort(positions);
        //정해진 조건에 부합했다면, 그 학생 앉히기.
        board[positions.get(0).x][positions.get(0).y] = new Student(num, prefer);
    }

    //만족하는 칸이 여러개면 주변의 빈 갯수 채우기.
    private static Position step_2(int x, int y, int[] prefer) {
        Position position = new Position(x, y);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (board[nx][ny] == null) {
                    position.empty++;
                }
                else{
                    for (int j = 0; j < prefer.length; j++) {
                        if (prefer[j] == board[nx][ny].num) {
                            position.like++;
                        }
                    }
                }
            }
        }
        return position;
    }

    static class Student{
        int num;
        int[] prefer;

        public Student(int num, int[] prefer) {
            this.num = num;
            this.prefer = prefer;
        }
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;
        int empty;
        int like;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position position) {
            if (this.like != position.like) {
                return position.like-this.like;
            }
            if (this.empty != position.empty) {
                return position.empty-this.empty;
            }
            if (this.x != position.x) {
                return this.x - position.x;
            }
            return this.y - position.y;
        }
    }

}
