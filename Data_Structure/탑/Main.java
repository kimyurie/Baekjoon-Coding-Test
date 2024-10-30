// https://www.acmicpc.net/problem/2493
package Data_Structure.탑;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 5
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 6 9 5 7 4
        int[] answer = new int[N];

        for(int i = 1; i <= N; i++) {
            // stack.peek()과 height 비교
            // 1. stack이 비어있을 때 stack[(1,6)] 추가
            //    answer 첫번째 값은 0
            // 2. stack [(1,6)]과 height 9 비교 ---> stack 6이 더 작으므로 stack에서 [1,6] 제거
            //    answer 두번째 값은 0
            // 3. stack [(2,9)]와 height 5 비교 ---> stack 9가 더 큼 ---> stack[[2,9], [3,5]]
            //    answer 세번째 값은 2
            // 4. stack [(3,5)]와 height 7 비교 ---> stack 3이 더 작으므로 stack에서 [3,5] 제거
            //    stack [(2,9)]와 height 7 비교 ---> stack 9가 더 큼 ---> stack[[2,9], [4,7]]
            //    answer 네번째 값은 2
            // 5. stack [(4,7)]와 height 4 비교 ---> stack 7이 더 큼
            //    answer 다섯번째 값은 4
            int height = Integer.parseInt(st.nextToken()); // 6

            while(!stack.isEmpty() && stack.peek()[1] < height) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                answer[i - 1] = stack.peek()[0]; // [0,0,2,2,4]
            }

            // stack[[1,6], [2,9], [3,5], [4,7], [5,4]]
            stack.push(new int[]{i, height}); // 탑들의 [번호, 높이] 순서로 저장
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
