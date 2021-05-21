public class LinearProbingHash {
    private Integer table[];
    public LinearProbingHash(Integer n) {table = new Integer[n];}
    public int hash(int value) {
        int hash = value % table.length;
        int index = hash;
        int i = 1;
        //tentativa linear
        while (table[index] != null){
            index = (hash + i) % table.length;
            i++;
        }
       return index;
    }
    public void put(int value){
        int index = hash(value);
        table[index] = value;
    }
    public void show(){
        for(int i = 0; i < table.length;i++)
            System.out.print(table[i]+" ");
    }
    public int findIndex(int value){
        int hash = value % table.length;
        int index = hash;
        int i = 1;
        //tentativa quadratica
        while (table[index] != null){
            if(table[index] == value)
                return index;
            index = (hash  + i) % table.length;
            i++;
        }
        return -1;
    }
}

