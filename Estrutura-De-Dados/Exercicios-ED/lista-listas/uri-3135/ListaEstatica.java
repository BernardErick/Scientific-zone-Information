public  class ListaEstatica {
    private String[] v;
    private int tamanho;

    public ListaEstatica(int n){
        this.v = new String[n];
        this.tamanho = 0;
    }
    public void exibir() {
        for (int i = 0; i < this.tamanho-1; i++)
            System.out.print(this.v[i] + ", ");
        System.out.print(this.v[this.tamanho-1]);
        System.out.println();
    }
    public void add(String valor){
        if(this.tamanho < this.v.length){
            this.v[tamanho] = valor;
            this.tamanho++;
        }
        else
            System.out.println("Lista cheia");
    }
    public boolean contem(String valor) {
        for (int i = 0; i < this.tamanho; i++){
            if (this.v[i].equals(valor)){
                return true;
            }
        }
        return false;
    }
    public void sort(){
        //selection sort
        for(int i = 0; i < this.tamanho - 1; i++)
        {
            // Encontrar o minimo elemento do vetor.
            int min_index = i;
            String minStr = this.v[i];
            for(int j = i + 1; j < this.tamanho; j++)
            {
                if(this.v[j].compareTo(minStr) < 0)
                {
                    minStr = this.v[j];
                    min_index = j;
                }
            }
            if(min_index != i)
            {
                String temp = this.v[min_index];
                this.v[min_index] = this.v[i];
                this.v[i] = temp;
            }
        }
    }
    public void bubbleSort()
    {
        String aux;
        for(int i = 0; i < this.tamanho -1;i++)
        {
            for(int z = 0; z < this.tamanho -1 - i;z++)
            {
                if(this.v[z].length() > this.v[z+1].length())
                {
                    aux = this.v[z];
                    this.v[z] = this.v[z+1];
                    this.v[z+1] = aux;
                }
            }
        }
    }
    public String removerPosicao(int pos) {
        String aux = this.v[pos];
        if (this.tamanho == 0)
            System.out.println("Lista vazia!");
        else if (pos < 0 || pos >= this.tamanho)
            System.out.println("Posicao invalida!");
        else {
            for (int i = pos; i < this.tamanho-1; i++)
                this.v[i] = this.v[i+1];
            this.tamanho--;
            return aux;
        }
        return null;
    }
    public String get(int pos){
        return this.v[pos];
    }
    public int tamanho() {
        return this.tamanho;
    }
}