// https://www.acmicpc.net/problem/19532
package Brute_Force.수학은비대면강의입니다;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 1
        int b = Integer.parseInt(st.nextToken()); // 3
        int c = Integer.parseInt(st.nextToken()); // -1
        int d = Integer.parseInt(st.nextToken()); // 4
        int e = Integer.parseInt(st.nextToken()); // 1
        int f = Integer.parseInt(st.nextToken()); // 7
        String answer = "";

        for(int x = -999; x <= 999; x++) {
            for(int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    answer += x + " " + y;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
