// https://www.acmicpc.net/problem/2164
package Data_Structure.카드2;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 1 2 3 4
        // 1버림 => 2 3 4
        // 3 4 2
        // 3버림 => 4 2
        // 2 4
        // 2버림 => 4

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 7

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        while(queue.size() > 1) {
            queue.poll(); // 1버림
            int a = queue.poll();
            queue.add(a);

            if(queue.size() == 1) {
                break;
            }
        }

        System.out.println(queue.poll());
    }
}
