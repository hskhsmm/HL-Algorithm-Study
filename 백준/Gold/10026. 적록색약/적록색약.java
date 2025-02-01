import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] arr;
    static boolean[][] check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        check = new boolean[N][N];

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int normalCount = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!check[i][j]) {
                    dfs(i, j, arr[i][j]);
                    normalCount++;
                }
            }
        }

        check = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        int blindCount = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!check[i][j]) {
                    dfs(i, j, arr[i][j]);
                    blindCount++;
                }
            }
        }

        System.out.println(normalCount);
        System.out.println(blindCount);
    }

    static void dfs(int x, int y, char color) {
        check[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!check[nx][ny] && arr[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }
}