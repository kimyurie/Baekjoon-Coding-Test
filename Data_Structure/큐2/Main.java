// https://www.acmicpc.net/problem/18258
package Data_Structure.큐2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine()); // 15
        // 시간 초과로 System.out.println 사용하지 말고 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 큐의 마지막 요소 저장하기 위한 변수
        int last = -1;

        for(int i = 0; i < N; i++) {
            // push 1
            StringTokenizer st = new StringTokenizer(br.readLine());
            // push
            String s = st.nextToken();

            switch(s) {
                case "push":
                    // 마지막 요소 업데이트
                    // => 큐는 FIFO 구조이므로 처음 들어온게 처음 나간다.
                    last = Integer.parseInt(st.nextToken());
                    queue.add(last);
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                case "back": // 큐의 가장 뒤에 있는 정수를 출력
                    sb.append(queue.isEmpty() ? -1 : last).append('\n');
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);

    }
}
