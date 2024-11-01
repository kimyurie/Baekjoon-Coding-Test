// https://www.acmicpc.net/problem/2075
package Data_Structure2.N번째큰수;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            // 12 7 9 15 5
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken()); // 12
                // 첫번째 행 큐에 추가
                // [5,7,9,12,15]
                // 두번째 행 큐에 추가
                // 13추가 --> 큐 최솟값 5제거후 추가 [7,9,12,15,13]
                // 8추가 --> 큐 최솟값 7제거후 추가 [9,12,15,13,8]
                // 11추가 --> 큐 최솟값 8제거후 추가 [9,12,13,15,11]
                // 19추가 --> 큐 최솟값 9제거후 추가 [11,12,13,15,19]
                // 6추가 --> 큐 최솟값 11보다 작으므로 큐 그대로 유지

                // (※우선순위 큐에 있는 원소들은 최솟값만 보장될 뿐,
                // 나머지 원소들이 순서대로 정렬되지 x)

                // 이후 행들 계속 반복하면 최솟값 다 제거 후 상위 5개 값만 남게 됌

                // 큐 크기가 N보다 작으면 그냥 추가
                if(pq.size() < N) {
                    pq.add(num);
                    // 큐 크기가 N 이상일 경우
                }else if(num > pq.peek()) {
                    pq.poll(); // 최솟값을 제거
                    pq.add(num); // 새 값을 추가
                }
            }
        }

        // N번째 큰 수는 큐의 최상위 원소
        System.out.println(pq.peek());
    }
}
