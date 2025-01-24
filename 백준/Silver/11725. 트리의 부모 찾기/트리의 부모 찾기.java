import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] check;
    static int Node;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node = Integer.parseInt(br.readLine());

        graph = new ArrayList[Node+1];

        //리스트 초기화 작업
        for(int i=1; i<=Node; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < Node-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);

        }
        check = new boolean[Node+1];
        parent = new int[Node+1];

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=Node; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);


    }


    static void dfs(int current) {
        check[current] = true;

        for(int next : graph[current]){
            if(!check[next]){
                parent[next] = current;
                dfs(next);
            }
        }
    }
}
