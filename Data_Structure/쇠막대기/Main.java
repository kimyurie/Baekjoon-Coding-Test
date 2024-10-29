// https://www.acmicpc.net/problem/10799
package Data_Structure.쇠막대기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') { // 쇠막대기의 시작을 의미 (각 막대기가 어디서 시작했는지 기록하는 용도)
                stack.push('(');
            }else { // s.charAt(i) == ')'
                stack.pop();
                if(s.charAt(i-1) == '(') { // 레이저를 의미
                    answer += stack.size();
                }else{ // ')'
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
