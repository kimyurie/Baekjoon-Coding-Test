// https://www.acmicpc.net/problem/11286
package Data_Structure2.절댓값힙;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 18
        StringBuilder sb = new StringBuilder();

        // 우선순위 큐 : 절댓값 기준으로 정렬, 절댓값이 같으면 실제 값으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            // 절댓값이 같을 경우 ex) 1과 -1일 경우
            if(absX == absY) {
                // Integer.compare()
                // 첫번째 정수가 두번째 정수보다 작은 경우 '음수값', 같은 경우 '0', 클 경우 '양수값
                return Integer.compare(x, y); // 실제 값이 작은 순대로 정렬  ex) 큐 상태는 [-1,1] 더작은 -1이 우선
            }else{  // 절댓값이 다를 경우 ex) |3| = 3, |-7| = 7
                return Integer.compare(absX, absY); // 큐 상태는 [3, -7] 절댓값 작은 3이 우선
            }
        });


        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append('\n');
                }else{
                    sb.append(pq.poll()).append('\n');
                }
            }else{
                pq.add(a);
            }
        }

        System.out.println(sb);

    }
}
