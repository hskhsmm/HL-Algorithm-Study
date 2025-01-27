import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];


        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;
        for(int h=0; h<=100; h++) {
            check = new boolean[N][N];
            int count = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] > h && !check[i][j]) {
                        dfs(i,j,h);
                        count++;
                    }
                }
            }

            if (count > maxCount) {
                maxCount = count;
            }

        }

        System.out.println(maxCount);

    }

    static void dfs(int x, int y, int h) {
        check[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny] && arr[nx][ny] > h) {
                dfs(nx, ny, h);

            }
        }



    }


}
