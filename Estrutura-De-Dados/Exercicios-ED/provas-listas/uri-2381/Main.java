import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ListaDinamica lista = new ListaDinamica();
        int N = in.nextInt();int K = in.nextInt();in.nextLine();
        for(int i = 0 ; i < N;i++)
            lista.addOrdenado(in.next());
        System.out.println(lista.get(K-1));

    }

}
