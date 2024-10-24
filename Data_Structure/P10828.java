// https://www.acmicpc.net/problem/10828
package Data_Structure;

import java.io.*;
import java.util.*;

public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 14
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // push 1
            String s = st.nextToken(); // push

            switch(s) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.size() == 0 ? -1 : stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.empty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(stack.size() == 0 ? -1 : stack.peek()).append('\n');
                    break;
                default:
            }
        }
        System.out.println(sb);
    }
}
