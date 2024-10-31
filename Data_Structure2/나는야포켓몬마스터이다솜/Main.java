// https://www.acmicpc.net/problem/1620
package Data_Structure2.나는야포켓몬마스터이다솜;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 26
        int M = Integer.parseInt(st.nextToken()); // 5
        StringBuilder sb = new StringBuilder();

        // 번호 -> 이름
        HashMap<Integer, String> hm1 = new HashMap<>();
        // 이름 -> 번호
        HashMap<String, Integer> hm2 = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            hm1.put(i, s);
            hm2.put(s, i);
        }

        for(int j = 0; j < M; j++) {
            String s = br.readLine();
            // 첫문자가 숫자라면
            // Character.isDigit => 해당 문자가 숫자면 true 반환, 문자면 false 반환
            if(Character.isDigit(s.charAt(0))) {
                // 문자열 출력
                sb.append(hm1.get(Integer.parseInt(s))).append('\n');
            } // 첫문자가 문자라면
            else{
                // 숫자 출력
                sb.append(hm2.get(s)).append('\n');
            }

        }
        System.out.println(sb);
    }
}
