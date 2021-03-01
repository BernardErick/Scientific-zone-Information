package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N;i++){
            int F1 = scanner.nextInt();
            int F2 = scanner.nextInt();
            System.out.println(mdc(F1,F2));
        }
    }
    //Algoritmo de Euclides
    //O primeiro caso é o caso base, isto é, se b é zero, então o MDC será a.
    //Isso faz sentido, pois zero é divisível por qualquer número inteiro (exceto zero).
    //O segundo caso é a solução recursiva: o MDC entre a e b é igual ao MDC entre b e o resto da divisão de a por b.
    public static int mdc(int f1, int f2){
        if(f2 == 0){
            return f1;
        }
        else{
            return mdc(f2, f1 % f2);
        }
    }
    //Exemplo:
    //mdc(30,60)
    //=mdc(60,30%60)
    //=mdc(60,30)
    //=mdc(30,60%30)
    //=mdc(30,0)
    //=30
}
