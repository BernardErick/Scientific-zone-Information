public  class ListaEstatica {
    private String[] v;
    private int tamanho;

    public ListaEstatica(int n){
        v = new String[n];
        tamanho = 0;
    }
    public void exibir() {
        for (int i = 0; i < tamanho; i++)
            System.out.print(v[i] + " ");
        System.out.println();
    }
    public void add(String valor){
        if(tamanho < v.length){
            v[tamanho] = valor;
            tamanho++;
        }
        else
            System.out.println("Lista cheia");
    }
    public boolean contem(String valor) {
        for (int i = 0; i < tamanho; i++){
            if (v[i].equals(valor)){
                return true;
            }
        }
        return false;
    }
    public void sort(){
        //selection sort
        for(int i = 0; i < tamanho - 1; i++)
        {
            // Encontrar o minimo elemento do vetor.
            int min_index = i;
            String minStr = v[i];
            for(int j = i + 1; j < tamanho; j++)
            {
                if(v[j].compareTo(minStr) < 0)
                {
                    minStr = v[j];
                    min_index = j;
                }
            }
            if(min_index != i)
            {
                String temp = v[min_index];
                v[min_index] = v[i];
                v[i] = temp;
            }
        }
    }
    public String get(int pos){
        return v[pos];
    }
    public int tamanho() {
        return tamanho;
    }
}
