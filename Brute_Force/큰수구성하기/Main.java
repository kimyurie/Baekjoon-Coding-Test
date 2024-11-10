// https://www.acmicpc.net/problem/18511
package Brute_Force.큰수구성하기;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, K, answer;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 657
        K = Integer.parseInt(st.nextToken()); // 3
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        arr = new int[K];
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            // [1,5,7]
        }

        Arrays.sort(arr); // 오름차순 정렬

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int total) {
        if(total > N) return; // 657보다 크면 반환
        if(answer < total) answer = total; // 답 계속 갱신

        for(int i = K-1; i >= 0; i--) { // 큰 숫자부터 탐색
            // 다음 자릿수를 붙임
            dfs(total * 10 + arr[i]);
            // dfs(0)일때,
            // 0 * 10 + arr[2] = 7  --> dfs(7)
            // 0 * 10 + arr[1] = 5  --> dfs(5)
            // 0 * 10 + arr[0] = 1  --> dfs(1)
            // dfs(7)일때,
            // 7 * 10 + arr[2] = 77 --> dfs(77)
            // 7 * 10 + arr[1] = 75 --> dfs(75)
            // 7 * 10 + arr[0] = 71 --> dfs(71)
            // dfs(5)일때,
            // 5 * 10 + arr[2] = 57 --> dfs(57)
            // 5 * 10 + arr[1] = 55 --> dfs(55)
            // 5 * 10 + arr[0] = 51 --> dfs(51)
            // ...
            // dfs(77)일때,
            // 77 * 10 + arr[2] = 777 --> 불가능 dfs 종료
        }

    }
}
