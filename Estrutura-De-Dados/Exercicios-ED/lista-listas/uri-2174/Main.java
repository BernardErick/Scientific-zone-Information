import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaEstatica pokedex = new ListaEstatica(151);

            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int X = 151;
            scanner.nextLine();
            for(int i = 0; i < N;i++){
                String S = scanner.nextLine();
                if(!pokedex.contem(S))
                    pokedex.adicionarFinal(S);
            }
            X = X - pokedex.tamanho();
            System.out.println("Falta(m) "+X+" pomekon(s).");

    }
}

