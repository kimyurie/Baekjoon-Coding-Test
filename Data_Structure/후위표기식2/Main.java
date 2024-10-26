// https://www.acmicpc.net/problem/1935
package Data_Structure.후위표기식2;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 5
        String s = br.readLine(); // ABC*+DE/-
        // 숫자 담을 배열
        double[] arr = new double[N];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(br.readLine()); // 1 2 3 4 5
        }
        // 피연산자가 나올때마다 담을 스택
        Stack<Double> stack = new Stack<>();

        double answer = 0;

        for(int i = 0; i < s.length(); i++) {
            // 피연산자가 나왔을 때
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                // 알파벳 - 'A' 차이 = 알파벳의 순서
                // ex) 'A' - 'A' = 0
                //     'B' - 'A' = 1
                stack.add(arr[s.charAt(i) - 'A']);
            // 연산자가 나왔을 때
            }else{
                double a = stack.pop(); // C
                double b = stack.pop(); // B
                switch(s.charAt(i)) {
                    case '+':
                        answer = b + a;
                        stack.push(answer);
                        continue;
                    case '-':
                        answer = b - a;
                        stack.push(answer);
                        continue;
                    case '*':
                        answer = b * a;
                        stack.push(answer);
                        continue;
                    case '/':
                        answer = b / a;
                        stack.push(answer);
                        continue;
                }
            }
        }
        // 소숫점 둘째 자리까지 출력
        System.out.printf("%.2f",stack.pop());
    }
}
