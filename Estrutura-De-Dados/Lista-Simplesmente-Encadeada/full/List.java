public class List
{
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public List() //construtor padrao
    {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    public List(int init) //construtor de 1 argumento inteiro
    {
        No novo = new No(init);
        primeiro = novo;
        ultimo = novo;
        tamanho = 1;
    }
    public List(List lista) //construtor de 1 argumento de lista
    {
        No aux = lista.getPrimeiroNoLista();
        while(aux != null)
        {
            No novo = new No(aux.getDado());
            if(primeiro == null)
            {
                primeiro = novo;
                ultimo = novo;
            }
            else
            {
                ultimo.setProximo(novo);
                ultimo = novo;
            }
            aux = aux.getProximo();
        }
        tamanho+=lista.tamanho();
    }
    public List(int[] vetor) //construtor de 1 argumento de lista
    {
        for(int i = 0; i <vetor.length;i++)
        {
            No aux = new No(vetor[i]);
            if(primeiro == null)
            {
                primeiro = aux;
                ultimo = aux;
            }
            else
            {
                ultimo.setProximo(aux);
                ultimo = aux;
            }
            tamanho++;
        }
    }

    public void  append(int valor)
    {
        No novo = new No(valor);
        if(primeiro == null)
        {
            primeiro = novo;
            ultimo = novo;
        }
        else
        {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }
    public void prepend(int valor)
    {
        No novo = new No(valor);
        if(primeiro == null)
        {
            primeiro = novo;
            ultimo = novo;
        }
        else
        {
            novo.setProximo(primeiro);
            primeiro = novo;
        }
        tamanho++;
    }
    public void exibir()
    {
        No aux = primeiro;
        while(aux!= null)
        {
            System.out.print(aux.getDado()+ " ");
            aux = aux.getProximo();
        }
        System.out.println();
    }
    public void removeEnd()
    {
        No aux = primeiro;
        for(int i = 0; i < tamanho-2;i++)
        {
            aux = aux.getProximo();
        }
        aux.setProximo(null);
        ultimo = aux;
        tamanho--;
    }
    public int valorPos(int pos)
    {
        No aux = primeiro;
        int i = 0;
        while(i < pos)
        {
            aux = aux.getProximo();
            i++;
        }
        return aux.getDado();
    }
    public void inserirPosicao(int valor, int pos)
    {
        No aux = primeiro;
        int i = 0;
        while(i < pos)
        {
            aux = aux.getProximo();
            i++;
        }
        aux.setDado(valor);
        tamanho++;
    }
    public void concatenar(List lista)
    {
        No aux = lista.getPrimeiroNoLista();
        while(aux != null)
        {
            No novo = new No(aux.getDado());
            if(primeiro == null)
            {
                primeiro = novo;
                ultimo = novo;
            }
            else
            {
                ultimo.setProximo(novo);
                ultimo = novo;
            }
            aux = aux.getProximo();
        }
        tamanho+=lista.tamanho();
    }
    public void inserirAposPosicao(int valor, int pos)
    {
        No aux = primeiro;
        int i = 0;
        while(i < pos)
        {
            aux = aux.getProximo();
            i++;
        }
        No novo = new No(valor); //novo valor(No) que vai ser adicionado
        No auxProx = aux.getProximo(); //é o No que vai ser passado para frente para entrar o novo
        aux.setProximo(novo);
        novo.setProximo(auxProx);
        tamanho++;
    }
    public void inverter()
    {
        List listaAux = new List();
        No aux = primeiro;
        while(aux != null)
        {
            listaAux.prepend(aux.getDado());
            aux = aux.getProximo();
        }
        primeiro = listaAux.getPrimeiroNoLista();
    }
    public void ordenar() //SE QUISER ORDENAR POR FUNÇÃO
    {
        No atual = null;
        No indice = null;
        int temp;
        if(primeiro == null)
        {
            return;
        }
        else
        {
            for(atual = primeiro; atual.getProximo() != null;atual = atual.getProximo())
            {
                for(indice = atual.getProximo();indice != null;indice = indice.getProximo())
                {
                    if(atual.getDado() > indice.getDado())
                    {
                        temp = atual.getDado();
                        atual.setDado(indice.getDado());
                        indice.setDado(temp);
                    }
                }
            }
        }
    }
    private No valorPosNo(int pos)
    {
        No aux = primeiro;
        int i = 0;
        while(i < pos)
        {
            aux = aux.getProximo();
            i++;
        }
        return aux;
    }
    public int removerPos(int pos)
    {
        No aux = primeiro;
        int i = 0;
        while(i < pos - 1)
        {
            i++;
            aux = aux.getProximo(); //vai guardar o antessesor
        }
        No aux2 = aux.getProximo(); //vai guardar o valor que vai ser removido
        aux.setProximo(aux2.getProximo());
        aux2.setProximo(null);
        tamanho--;
        return aux2.getDado();
    }
    public int indice(int v)
    {
        No aux = primeiro;
        int i = 0;
        while(aux!=null)
        {
            if(aux.getDado() == v)
            {
                break;
            }
            i++;
            aux = aux.getProximo();
        }
        return i;
    }
    public int[] array ()
    {
        No aux = primeiro;
        int[]auxvetor = new int[tamanho];
        int i=0;
        while(aux!=null)
        {
            auxvetor[i]=aux.getDado();
            aux = aux.getProximo();
            i++;
        }
        return auxvetor;
    }
    public boolean pertence(int valor)
    {
        No aux = primeiro;
        while(aux!=null)
        {
            if(aux.getDado()==valor)
            {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }
    public int contar(int v)
    {
        No aux = primeiro;
        int contar = 0;
        while(aux!=null)
        {
            if(aux.getDado() == v)
            {
                contar++;
            }
            aux = aux.getProximo();
        }
        return contar;
    }
    public No clonar()
    {
        return primeiro;
    }
    public void appendArray(int[] vetor)
    {
        for(int i = 0; i <vetor.length;i++)
        {
            append(vetor[i]);
        }
    }
    public void prependArray(int[] vetor)
    {
        for(int i = 0; i <vetor.length;i++)
        {
            prepend(vetor[i]);
        }
    }
    public void inserirListaPosicao(List lista,int pos)
    {
        int i = 0;
        No aux = primeiro;
        while(i <= pos)
        {
            if(i == pos)
            {
                No aux2 = aux.getProximo(); //antigo sucessor
                for(int z = 0; z < lista.tamanho();z++)
                {
                    No novo = new No(lista.valorPos(z));
                    aux.setProximo(novo);
                    aux = aux.getProximo();
                    ultimo = aux;
                }
                while(aux2 != null)
                {
                    No novo = new No(aux2.getDado());
                    ultimo.setProximo(novo);
                    ultimo = novo;
                    aux2 = aux2.getProximo();
                }
                break;
            }
            i++;
            aux = aux.getProximo();
        }
    }

    public int tamanho()
    {
        return tamanho;
    }
    public int ultimoElemento()
    {
        return ultimo.getDado();
    }
    private int getPrimeiroLista()
    {
        return primeiro.getDado();
    }
    private int getUltimoLista()
    {
        return ultimo.getDado();
    }
    private No getPrimeiroNoLista()
    {
        return primeiro;
    }
    private No getUltimoNoLista()
    {
        return ultimo;
    }


}