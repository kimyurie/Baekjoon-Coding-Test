// https://www.acmicpc.net/problem/9012
package Data_Structure.괄호;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 6

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine(); // (())()) --> 공백으로 구분되지 않으므로 StringTokenizer 쓰지 않기
            boolean flag = true;

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j); // 한글자씩 검사

                if(ch == '(') {
                    stack.push(ch);
                }else{ // ch가 ')'일때
                    if(stack.empty()) {
                        flag = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(flag && stack.empty()) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }
}
