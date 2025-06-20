import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2]; // 시작 시간, 종료 시간

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료 시간 오름차순 → 종료 시간이 같으면 시작 시간 오름차순
        Arrays.sort(time, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int cnt = 1; // 첫 회의는 무조건
        int end = time[0][1]; // 첫 회의 종료 

        for (int i = 1; i < N; i++) {
            if (time[i][0] >= end) {
                end = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
