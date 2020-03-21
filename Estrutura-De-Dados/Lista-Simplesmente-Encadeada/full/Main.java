public class Main
{
    public static void main(String[] args) {
        List lista1 = new List(2);
        lista1.append(3);
        lista1.append(8);
        lista1.append(5);
        lista1.exibir();
        List lista2 = new List(10);
        lista2.append(20);
        lista2.append(30);
        lista2.append(40);
        lista2.append(50);
        lista2.append(60);
        lista2.exibir();
        lista2.inserirListaPosicao(lista1,2);
        System.out.println("O ultimo elemento é: "+ lista2.ultimoElemento());
        lista2.exibir();

    }
}
