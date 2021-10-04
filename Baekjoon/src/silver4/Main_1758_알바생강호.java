package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1758_알바생강호 {
    public static void main(String[] args) throws IOException {
        //팁의 최댓값
        //N<=100,000 Positive Integer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long sum = 0;
        int idx = 1;
        while (!pq.isEmpty()) {
            int tip = pq.poll() - (idx++ - 1);
            if (tip < 0) break;
            sum += tip;
        }
        System.out.println(sum);
    }
}

