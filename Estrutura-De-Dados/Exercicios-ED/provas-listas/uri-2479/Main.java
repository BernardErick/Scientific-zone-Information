package Exemplo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada();
        int N = in.nextInt();
        int comportados = 0;
        int malcomportados = 0;
        in.nextLine();
        for(int i = 0; i < N; i++){
            String test = in.next();
            String nome = in.next();
            lista.addOrdenado(nome);
            if(test.equals("+"))
                comportados++;
            if(test.equals("-"))
                malcomportados++;
        }
        lista.exibir();
        System.out.println("Se comportaram: "+comportados+" | Nao se comportaram: "+malcomportados);

    }

}
