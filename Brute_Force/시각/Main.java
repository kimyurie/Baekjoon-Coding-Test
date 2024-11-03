// https://www.acmicpc.net/problem/18312
package Brute_Force.시각;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 5
        String K = st.nextToken(); // 3
        // 5시 59분 59초까지의 모든 시각 중 3이 하나라도 포함되는 모든 시각 세기
        // [00, 00, 00] 형태로
        // 00 01 02 03 04 05 06 07 08 09 10
        // 11 12 13 14 15 16 17 18 19 20


        int count = 0;
        for(int h = 0; h <= N; h++) { // 시
            for(int m = 0; m <= 59; m++) { // 분
                for(int s = 0; s <= 59; s++) { // 초
                   // 현재 시각을 HHMMSS 형식으로 포맷
                   String time = String.format("%02d%02d%02d", h, m, s);

                    if(time.contains(K)) {
                        count++;
                    }
                }
            }
        }


        System.out.println(count);

    }
}
