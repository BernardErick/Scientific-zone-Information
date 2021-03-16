import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada();
        int n = 4;
        for(int i = 0; i< n;i++){
            String frase = scanner.nextLine();
            lista.addOrdenado(frase);
        }
        lista.exibir();
    }
}
