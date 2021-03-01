package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int NC = scanner.nextInt();
        for(int i = 1; i <= NC; i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(josephus(n,k));
        }
    }
    public static int josephus(int n, int k){
        return n > 1 ? (josephus(n-1, k) + k - 1) % n + 1 : 1;
    }
}
