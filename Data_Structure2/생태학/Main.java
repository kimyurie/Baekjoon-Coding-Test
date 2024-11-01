// https://www.acmicpc.net/problem/4358
package Data_Structure2.생태학;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // TreeMap : 키값이 알파벳순(오름차순)으로 정렬된 상태로 출력
        TreeMap<String, Integer> tm = new TreeMap<>();
        String name;
        int sum = 0; // 전체 이름 개수

        // 다음에 나올 문자가 null이 아니면
        while((name = br.readLine()) != null) {
            // getOrDefault() 이용 -> 이미 저장된 이름이라면 기존 개수 +1, 새로운 이름이라면 기본값 0
            tm.put(name, tm.getOrDefault(name, 0) + 1);
            sum++;
        }

        // 비율 계산 및 출력 준비
        for(Map.Entry<String, Integer> entry: tm.entrySet()) {
            String s = entry.getKey(); // 이름
            int num = entry.getValue();// 이름 개수
            // 비율 계산 = (한 종의 이름 개수 / 전체 이름 개수) * 100
            double percentage = (num / (double)sum) * 100;
            // String.format을 이용해 소수점 네 번째 자리까지 포맷
            sb.append(String.format("%s %.4f%n", s, percentage));
        }

        System.out.println(sb);
    }
}
