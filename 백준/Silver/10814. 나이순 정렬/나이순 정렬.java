import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];


        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();

        }

        Arrays.sort(arr, (o1, o2) -> {
            if(Integer.parseInt(o1[0]) > Integer.parseInt(o2[0])) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            } else if(Integer.parseInt(o1[0]) < Integer.parseInt(o2[0])) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
            return 0;
            });

        for(int i=0; i<N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }
}
