package com.company;

import java.util.Scanner;


public class Main {
    public static int calls = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N;i++){
            int X = scanner.nextInt();
            int fib = fib(X);
            System.out.println("fib("+X+") = "+(calls-1)+" calls = "+fib);
            calls = 0;
        }
    }

    public static int fib(int n){

        if(n == 0){
            calls++;
            return 0;
        }
        else if(n == 1){
            calls++;
            return 1;
        }
        else{
            calls++;
            return fib(n - 1) + fib(n - 2);
        }
    }
}
