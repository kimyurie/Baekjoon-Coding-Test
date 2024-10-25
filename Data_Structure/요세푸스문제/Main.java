// https://www.acmicpc.net/problem/1158
package Data_Structure.요세푸스문제;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 7
        int K = Integer.parseInt(st.nextToken()); // 3
        // 1 2 3 4 5 6 7
        // 제거할 수 => 제거 후 남은 숫자 순서
        // 3 제거 => 4 5 6 7 1 2
        // 6 제거 => 7 1 2 4 5
        // 2 제거 => 4 5 7 1
        // 7 제거 => 1 4 5
        // 5 제거 => 1 4
        // 1 제거 => 4
        // 4 제거
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("<");

        for(int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        // 3번째 숫자 나올 때까지 앞에 숫자 빼서 뒤에 넣기
        while(!queue.isEmpty()) {
            for(int i = 0; i < K - 1; i++) {
                int a = queue.poll(); // 제일 앞에 숫자 제거
                queue.add(a);
            }
            sb.append(queue.poll());
            if(!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);

    }
}
