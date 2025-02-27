import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[100001]; // 최소 시간을 저장하는 배열
        boolean[] check = new boolean[100001]; // 방문 여부 체크
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return time[a] - time[b];
            }
        });

        // 초기화
        for (int i = 0; i <= 100000; i++) {
            time[i] = Integer.MAX_VALUE;
        }

        // 시작점 설정
        time[N] = 0;
        pq.add(N);

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            if (cur == K) {
                System.out.println(time[cur]);
                return;
            }

            // 0
            if (cur * 2 <= 100000 && time[cur * 2] > time[cur]) {
                time[cur * 2] = time[cur];
                pq.add(cur * 2);
            }

            // +1 
            if (cur + 1 <= 100000 && time[cur + 1] > time[cur] + 1) {
                time[cur + 1] = time[cur] + 1;
                pq.add(cur + 1);
            }

            // -1 
            if (cur - 1 >= 0 && time[cur - 1] > time[cur] + 1) {
                time[cur - 1] = time[cur] + 1;
                pq.add(cur - 1);
            }
        }
    }
}
