import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < N;i++){
            List list = new List();
            String items = scanner.nextLine();
            String[] item = items.split(" ");
            for(int j = 0; j < item.length;j++){
                if(!list.contem(item[j]))
                    list.addOrdenado(item[j]);
            };
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < list.tamanho();j++)
                builder.append(list.get(j)+" ");
            System.out.println(builder.toString().trim());
        }

    }

}
