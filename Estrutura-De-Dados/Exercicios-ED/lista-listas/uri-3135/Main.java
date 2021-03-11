import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        ListaEstatica nomes = new ListaEstatica(1000);
        for(int i = 0; i < N;i++){
            nomes.add(in.nextLine());
        }
        nomes.bubbleSort();
        while (nomes.tamanho() != 0){
            ListaEstatica linha = new ListaEstatica(1000);
            int indiceMaior = 0;
            linha.add(nomes.removerPosicao(0));
            for(int i = 0; i < nomes.tamanho();i++){
                if(nomes.get(i).length() > linha.get(indiceMaior).length()){
                    linha.add(nomes.removerPosicao(i));
                    indiceMaior++;
                    i--;
                }
            }
            linha.exibir();
        }
    }
}
