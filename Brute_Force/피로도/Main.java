// https://www.acmicpc.net/problem/22864
package Brute_Force.피로도;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 5
        int B = Integer.parseInt(st.nextToken()); // 3
        int C = Integer.parseInt(st.nextToken()); // 2
        int M = Integer.parseInt(st.nextToken()); // 10

        // 하루에 1시간 일하면 피로도는 5만큼 쌓이고
        //                  일은 3만큼 처리할 수 있다
        //       1시간 쉰다면 피로도는 2만큼 줄어든다
        //       피로도가 10 넘게 일하면 일을 그만 두게 된다

        int fatigue = 0; // 현재 피로도
        int workDone = 0; // 총 처리한 일의 양

        for(int time = 0; time < 24; time++) {
            // 일을 할 수 있는 경우
            // => 피로도를 최대한 M을 넘지 않는단 조건을 이용
            if(fatigue + A <= M) {
                fatigue += A;
                workDone += B;
                // 쉬어야 하는 경우
            }else {
                fatigue -= C;
                if(fatigue < 0) fatigue = 0;
            }
        }
        System.out.println(workDone);
    }
}