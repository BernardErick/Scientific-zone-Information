public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adicionarFinal(1);
        lista.adicionarFinal(2);
        lista.adicionarFinal(3);
        lista.adicionarFinal(4);
        lista.adicionarPosicao(6,0);
        lista.exibir();
    }
}
