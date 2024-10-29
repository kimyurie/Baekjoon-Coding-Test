// https://www.acmicpc.net/problem/2504
package Data_Structure.괄호의값;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // (()[[]])([])
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int temp = 1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
                temp *= 2;
            }else if(s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                temp *= 3;
            }else if(s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() == '[' || stack.peek() == ']' ) {
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1) == '(') {  // stack.peek()이 아니라 s.charAt(i-1)
                    answer += temp;
                }
                stack.pop();
                temp /= 2;  // temp값 초기화

            }else if(s.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() == '(' || stack.peek() == ')') {
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1) == '[') {  // stack.peek()이 아니라 s.charAt(i-1)
                    answer += temp;
                }
                stack.pop();
                temp /= 3; // temp값 초기화
            }
        }

        if(!stack.isEmpty()) {
            System.out.println(0);
        }else{
            System.out.println(answer);
        }

    }
}
