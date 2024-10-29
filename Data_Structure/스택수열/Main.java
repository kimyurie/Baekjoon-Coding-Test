// https://www.acmicpc.net/problem/1874
package Data_Structure.스택수열;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
// => 예제 입력으로 나온 값들은 스택에서 pop()된 순서대로 나타남
//       stack           result(예제 입력)
//        {1}+
//        {1,2}+
//        {1,2,3}+
//        {1,2,3,4}+           {4}
//        {1,2,3}-
//        {1,2}-               {4,3}
//        {1,2,5}+
//        {1,2,5,6}+
//        {1,2,5}-             {4,3,6}
//        {1,2,5,7}+
//        {1,2,5,7,8}+
//        {1,2,5,7}-           {4,3,6,8}
//        {1,2,5}-             {4,3,6,8,7}
//        {1,2}-               {4,3,6,8,7,5}
//        {1}-                 {4,3,6,8,7,5,2}
//        {}-                  {4,3,6,8,7,5,2,1}
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 8
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine()); // 4
            if(a > start) { // 이전 예제 입력 값과 비교
                for(int j = start + 1; j <= a; j++) {
                    st.push(j); // {1,2,3,4}
                    sb.append("+").append("\n");
                }
                start = a;
            }

            // top에 있는 원소가 입력받은 값과 같이 않은 경우
            if(st.peek() != a) {
                System.out.println("NO");
                return;
            }

            st.pop(); // {1,2,3} 4(x)
            sb.append("-").append("\n");

        }
        System.out.println(sb);
    }
}
