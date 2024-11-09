// https://www.acmicpc.net/problem/2798
package Brute_Force.블랙잭;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 5
        int M = Integer.parseInt(st.nextToken()); // 21

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;

        // 배열에 넣기
        int[] arr = new int[N];
        for(int a = 0; a < N; a++) {
            arr[a] = Integer.parseInt(st2.nextToken());
            // [5,6,7,8,9]
        }

        // 3가지 수 더하는 모든 경우의 수 찾기
        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int z = j+1; z < N; z++) {
                    int sum = (arr[i] + arr[j] + arr[z]);

                    // 조건 만족하는 수 중 최댓값 찾음
                    if(sum <= M) {
                        if(sum > answer){
                            answer = sum;
                        }
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
