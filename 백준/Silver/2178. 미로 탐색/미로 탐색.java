import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {
    static int[][] arr; //미로 정보 저장
    static boolean[][] check;
    static int[] dx = {-1,1,0,0}; //방문 여부 체크
    static int[] dy = {0,0,-1,1};
    static int N,M; //N은 행 M은 열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //미로 정보와 방문 여부 배열 초기화
        arr = new int[N+1][M+1];
        check = new boolean[N+1][M+1];   //N과M으로 하면 nx와 ny가 범위 벗어날 수도 있어서 하나 더 추가

        //미로 정보 입력
        for(int i=0; i<N; i++) {
            String line = br.readLine(); //각 행을 문자열로 읽어옴
            for(int j=0; j<M; j++) {
                arr[i][j] = line.charAt(j) - '0'; //문자를 숫자로 변환하여 저장
            }
        }

        bfs(0,0);
        System.out.println(arr[N-1][M-1]);


    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        check[x][y] = true;


        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && ny >= 0 && !check[nx][ny] && arr[nx][ny] == 1) {
                    q.add(new Point(nx,ny));
                    check[nx][ny] = true;
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                }
            }
        }
    }


}
