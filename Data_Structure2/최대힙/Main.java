// https://www.acmicpc.net/problem/11279
package Data_Structure2.최대힙;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 13
        // 우선순위 큐 - Collections.reverseOrder() 써서 높은 수가 우선이 되게
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a > 0) {
                pq.add(a);
            }else if(a == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append('\n');
                }else{
                    sb.append(pq.poll()).append('\n');
                }
            }
        }

        System.out.println(sb);

    }
}
