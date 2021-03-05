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
    public void adicionarFinal(String valor){
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

    public int tamanho() {
        return tamanho;
    }
}
