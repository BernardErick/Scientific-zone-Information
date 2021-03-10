public class List
{
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public List()
    {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    public void addOrdenado(String valor) //SE QUISER ORDENAR NA HORA DE ADICIONAR
    {
        No novo = new No(valor);
        No temp;
        No p;
        boolean ins = false;
        if(this.primeiro == null)
        {
            this.primeiro = novo;
            this.ultimo = novo;
        }
        else if (valor.compareTo(this.primeiro.dado) <= 0)
        {
            novo.proximo = this.primeiro;
            this.primeiro.anterior = novo; //5 - 9 - 1
            this.primeiro = novo;
        }
        else
        {
            temp = this.primeiro;
            p = this.primeiro.proximo;
            while(p != null)
            {
                if(valor.compareTo(temp.dado) >= 0 && valor.compareTo(p.dado) <= 0) //5 - 9 -1
                {
                    temp.proximo = novo;
                    novo.anterior = temp;
                    novo.proximo = p;
                    p.anterior = novo;
                    ins = true;
                    break;
                }
                else
                {
                    temp = p;
                    p = p.proximo;
                }
            }
            if(!ins)
            {
                temp.proximo = novo;
                novo.anterior = temp;
                this.ultimo = novo;
            }
        }
        this.tamanho++;
    }
    public boolean contem(String valor){
        No aux = this.primeiro;
        No chave = new No(valor);
        while (aux != null){
            if(aux.dado.compareTo(chave.dado) == 0){
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }
    public String get(int pos){
        No aux = this.primeiro;
        int i = 0;
        if(pos >= 0 && pos < this.tamanho)
        {
            while(i < pos)
            {
                aux = aux.proximo;
                i++;
            }
            if(aux != null)
            {
                return aux.dado;
            }
        }
        return null;
    }
    public int tamanho()
    {
        return this.tamanho;
    }
}
