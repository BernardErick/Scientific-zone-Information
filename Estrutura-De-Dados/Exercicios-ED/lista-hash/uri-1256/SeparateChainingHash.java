public class SeparateChainingHash {
    private LinkedList table[];
    public SeparateChainingHash(Integer n) {
        table = new LinkedList[n];
        for(int i =0; i < table.length;i++)
            table[i] = new LinkedList();
    }
    public int hash(int value) {
        int hash = value % table.length;
        return hash;
    }
    public void put(int value){
        int index = hash(value);
        table[index].append(value);
    }
    public void show(){
        for(int i = 0; i < table.length;i++){
            System.out.print(i+" -> ");
            if(table[i].vazia())
                System.out.println("\\");
            else{
                table[i].exibir();
            }
        }
    }
    public int findIndex(int value){
        int index = hash(value);
        return  table[index].indice(value);
    }
}
