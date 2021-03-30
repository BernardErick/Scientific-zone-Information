import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome = "";
        String status = "";
        ListaDinamica listaSim = new ListaDinamica();
        ListaDinamica listaNao = new ListaDinamica();
        //ENTRADA
        while(true){
            nome = in.next();
            if(nome.equals("FIM"))
                break;
            status = in.next();
            if(status.equals("YES"))
                if(!listaSim.contem(nome))
                    listaSim.add(nome);
            if(status.equals("NO"))
                if(!listaNao.contem(nome))
                    listaNao.addOrdenado(nome);
        }
        //ACHANDO O VENCEDOR
        String maiorNome = listaSim.get(0);
        if(listaSim.tamanho() != 1)
            for(int i = 1; i < listaSim.tamanho();i++)
                if(listaSim.get(i).length() > maiorNome.length())
                    maiorNome = listaSim.get(i);
        listaSim.ordenar();
        //SAIDA
        listaSim.exibir();
        listaNao.exibir();
        System.out.println();
        System.out.println("Amigo do Habay:");
        System.out.println(maiorNome);
    }

}
