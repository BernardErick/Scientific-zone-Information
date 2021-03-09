import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < N;i++){
            ListaEstatica list = new ListaEstatica(1000);
            String items = scanner.nextLine();
            String[] separate = items.split(" ");
            for(int j = 0; j < separate.length;j++){
                if(!list.contem(separate[j]))
                    list.add(separate[j]);
            };
            list.sort();
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < list.tamanho();j++)
                builder.append(list.get(j)+" ");
            System.out.println(builder.toString().trim());
        }

    }
}