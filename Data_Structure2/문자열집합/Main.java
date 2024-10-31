// https://www.acmicpc.net/problem/14425
package Data_Structure2.문자열집합;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 5
        int M = Integer.parseInt(st.nextToken()); // 11

        HashMap<Integer, String> hm = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            hm.put(i,s);
        }

        int answer = 0;
        for(int j = 0; j < M; j++) {
            String s = br.readLine();
            if(hm.containsValue(s)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
