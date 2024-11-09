// https://www.acmicpc.net/problem/2231
package Brute_Force.분해합;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine(); // "216"
        // 198 = 198 + 1 + 9 + 8 = 216
        int answer = 0;

        for(int i = 1; i < Integer.parseInt(N)-1; i++) {
            int sum = i; // 분해합
            int temp = i;

            // 각 자릿수 합 계산
            while(temp != 0) {
                // 216 % 10 = 6 ---> sum += 6
                // 216 / 10 = 21
                // 21 % 10 = 1 ---> sum += 1
                // 21 / 10 = 2
                // 2 % 10 = 2 ---> sum += 2
                // 2 / 10 = 0
                sum += temp % 10; // 마지막 자릿수를 더함 (각 자릿수 더함)
                temp /= 10;  // 마지막 자릿수 제거된 수 temp
            }

            // 분해합이 N과 같다면 결과 반환
            if(sum == Integer.parseInt(N)) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }
}