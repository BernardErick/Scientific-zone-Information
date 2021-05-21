
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);int N = in.nextInt();
        for (int i = 0; i < N;i++){
            int L = in.nextInt();int contador = 0;
            for(int j = 0; j < L;j++)
                contador+= hash(in.next(),j);
            System.out.println(contador);
        }
    }
    static int hash(String str,int entry){
        int sum = 0;
        for (int i = 0; i < str.length();i++){
            int indice = str.charAt(i) - 65; //A = 0 , B = 1 , ...
            sum+=indice;sum+=i;sum+=entry;
        }
        return sum;
    }
}
