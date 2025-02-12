import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] check;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(); //결과 저장

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            check = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int finalX = Integer.parseInt(st.nextToken());
            int finalY = Integer.parseInt(st.nextToken());

            //시작과 끝이 같다면
            if(curX == finalX && curY == finalY) {
                sb.append("0\n");
                continue;
            }
            //bfs 실행 값 저장
            sb.append(bfs(curX,curY,finalX,finalY)).append("\n");

        }
        System.out.println(sb);

    }

    static int bfs(int curX, int curY, int finalX, int finalY) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(curX,curY));
        check[curX][curY] = true;

        int moves = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                Point now = q.poll();
                int x = now.x;
                int y = now.y;

                if(x == finalX && y == finalY) {
                    return moves;
                }

                for(int i=0; i<8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    //체스판 위, 방문 x
                    if(nx >=0 && nx <N && ny >= 0 && ny < N && !check[nx][ny]) {
                        q.offer(new Point(nx,ny));
                        check[nx][ny] = true;
                    }
                }
            }
            moves++; //횟수 증가
        }
        return -1;
    }
}
