import jdk.swing.interop.SwingInterOpUtils;

import java.util.Hashtable;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            SeparateChainingHash table = new SeparateChainingHash(8);
            table.put(14);
            table.put(20);
            table.put(17);
            table.put(36);
            table.put(22);
            table.put(4);
            table.show();
    }
}
