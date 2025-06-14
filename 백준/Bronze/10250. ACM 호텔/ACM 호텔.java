import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); 
            int W = Integer.parseInt(st.nextToken());  //낚시네
            int N = Integer.parseInt(st.nextToken()); 

            int floor = N % H;        
            int roomNumber = N / H + 1; //호수는 1호부터

            if (floor == 0) {
                floor = H;
                roomNumber = N / H;
            }

            System.out.println(floor * 100 + roomNumber);
        }
    }
}