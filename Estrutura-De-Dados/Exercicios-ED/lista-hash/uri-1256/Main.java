
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);int N = in.nextInt();in.nextLine();
        for(int i = 0; i < N; i++){
            String[] T1 = in.nextLine().split(" ");int M = Integer.parseInt(T1[0]); int C = Integer.parseInt(T1[1]);
            SeparateChainingHash table = new SeparateChainingHash(M);
            String[] T2 = in.nextLine().split(" ");
            for(int j = 0; j < C;j++)
                table.put(Integer.parseInt(T2[j]));
            table.show();
            if(i == N-1)
                break;
            System.out.println();
        }
    }
}
