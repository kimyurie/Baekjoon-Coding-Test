// https://www.acmicpc.net/problem/1966
package Data_Structure.프린터큐;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 3
        StringTokenizer st;

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()); // 4 2
            int N = Integer.parseInt(st.nextToken()); // 4
            int M = Integer.parseInt(st.nextToken()); // 2번째 문서가 몇번째로 출력되는지

            Queue<int[]> queue = new LinkedList<int[]>(); // 배열 형태 큐
            st = new StringTokenizer(br.readLine()); // 1 2 3 4

            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken()); // 1
                queue.add(new int[]{j, num}); // [문서의 위치, 중요도] 형태로 저장
            } // queue = [[0, 1], [1, 2], [2, 3], [3, 4]]

            int cnt = 0;
            while(true) {
                int[] a = queue.poll(); // a = [0,1]
                boolean check = true; // 중요도가 높은 것 있는지 여부

                for(int[] q : queue) { // queue = [[1, 2], [2, 3], [3, 4]]
                    // q가 [1,2]일 때
                    if(q[1] > a[1]) { // q[1] = 2 > a[1] = 1
                        check = false;
                        break;
                    }
                }

                if(check) {
                    cnt++;
                    if(a[0] == M) break;
                }else {
                    queue.add(a); // 큐에 다시 추가
                    // queue: [[1, 2], [2, 3], [3, 4], [0, 1]]
                }
            }

            System.out.println(cnt);
        }
    }
}