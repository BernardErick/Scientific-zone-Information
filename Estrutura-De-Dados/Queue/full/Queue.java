public class Queue
{
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Queue() //construtor padrao
    {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    public Queue(int init) //construtor de 1 argumento inteiro
    {
        No novo = new No(init);
        primeiro = novo;
        ultimo = novo;
        tamanho = 1;
    }
    public Queue(Queue lista) //construtor de 1 argumento de lista
    {
        concatenar(lista);
    }
    public Queue(int[] vetor) //construtor de 1 argumento de lista
    {
        appendArray(vetor);
    }
    public void enfileirar(int valor)
    {
        No novo = new No(valor);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    public Object desenfileirar()
    {
        if (primeiro != null)
        {
            No aux = primeiro;

            primeiro = primeiro.getProximo();
            aux.setProximo(null);
            tamanho--;
            return aux.getDado();
        }
        return null;
    }
    public void exibir()
    {
        Queue novaFila = new Queue(); //nova fila criada
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        for(int i = 0; i < tamanhoReal;i++)
        {
            int num = (int)desenfileirar(); //Uso de casting para armazenar o número
            System.out.print(num + " "); //exibindo ele
            novaFila.enfileirar(num); //jogando ele na nova fila
        }
        //normalizando a fila
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
    }
    public void inserirPosicao(int valor, int pos)
    {
        if(pos >= tamanho) //verificador
        {
            System.out.println("Posição invalida!");
        }
        else
        {
            Queue novaFila = new Queue(); //nova fila criada
            for(int i = 0; i < pos;i++)
            {
                novaFila.enfileirar((int)desenfileirar()); //jogando ele na nova fila
            }

            novaFila.enfileirar(valor);
            int tamanhoReal = tamanho; //salvado a quantidade de repetições

            for(int i = 0; i < tamanhoReal;i++)
            {
                novaFila.enfileirar((int)desenfileirar()); //jogando ele na nova fila
            }
            //reatribuindo os ponteiros
            tamanhoReal = novaFila.tamanho();
            for(int i = 0; i < tamanhoReal;i++)
            {
                enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
            }
        }

    }
    public int valorPosicao(int pos)
    {
        if(pos >= tamanho) //verificador
        {
            System.out.println("Posição invalida!");
            return -1;
        }

        Queue novaFila = new Queue(); //nova fila criada
        for(int i = 0; i <= pos;i++)
        {
            int num = (int)desenfileirar();
            novaFila.enfileirar(num); //jogando ele na nova fila
        }

        int valor = novaFila.getUltimoLista();
        int tamanhoReal = tamanho; //salvado a quantidade de repetições restantes

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando o resto na nova fila
        }

        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
        return valor;

    }
    private No valorPosicaoNo(int pos)
    {
        if(pos >= tamanho) //verificador
        {
            System.out.println("Posição invalida!");
            return null;
        }

        Queue novaFila = new Queue(); //nova fila criada
        for(int i = 0; i <= pos;i++)
        {
            int num = (int)desenfileirar();
            novaFila.enfileirar(num); //jogando ele na nova fila
        }

        No valor = novaFila.getUltimoNoLista();
        int tamanhoReal = tamanho; //salvado a quantidade de repetições restantes

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando o resto na nova fila
        }

        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
        return valor;

    }
    public void inserirAposPosicao(int valor, int pos)
    {
        if(pos >= tamanho) //verificador
        {
            System.out.println("Posição invalida!");
        }
        else
        {
            Queue novaFila = new Queue(); //nova fila criada
            for(int i = 0; i <= pos;i++)
            {
                int num = (int)desenfileirar();
                novaFila.enfileirar(num); //jogando ele na nova fila
            }

            novaFila.enfileirar(valor);
            int tamanhoReal = tamanho; //salvado a quantidade de repetições restantes

            for(int i = 0; i < tamanhoReal;i++)
            {
                novaFila.enfileirar((int)desenfileirar()); //jogando o resto na nova fila
            }
            //reatribuindo os ponteiros
            tamanhoReal = novaFila.tamanho();
            for(int i = 0; i < tamanhoReal;i++)
            {
                enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
            }

        }


    }
    public void concatenar(Queue fila)
    {
        Queue novaFila = new Queue(); //nova fila criada
        int tamanhoReal = tamanho; //salvado a quantidade de repetições restantes

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando ele na nova fila
        }

        int tamanhoRealAux = fila.tamanho();
        for(int i = 0; i < tamanhoRealAux;i++)
        {
            novaFila.enfileirar((int)fila.desenfileirar()); //jogando ele na nova fila
        }

        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }


    }

    public No clonar()
    {
        Queue listaAux = new Queue(this);
        No listaCopia = listaAux.getPrimeiroNoLista();
        return listaCopia;
    }
    public int contar(int valor)
    {
        Queue novaFila = new Queue(); //nova fila criada
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        int cont = 0;
        for(int i = 0; i < tamanhoReal;i++)
        {
            int num = (int)desenfileirar(); //Uso de casting para armazenar o número
            if(num == valor)
            {
                cont++;
            }
            novaFila.enfileirar(num); //jogando ele na nova fila
        }

        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
        return cont;
    }
    public void inverter()
    {
        int tamAux = tamanho;
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        Queue aux2 = new Queue();
        for(int z =0; z < tamAux;z++)
        {
            Queue aux1 = new Queue();
            for(int i = 0; i < tamanhoReal -1;i++)
            {
                aux1.enfileirar((int)desenfileirar()); //jogando ele na nova fila
            }
            aux2.enfileirar((int)desenfileirar());
            tamanhoReal--;
            //passando o a aux1 como o primeiro e resentando o loop
            tamanhoReal = aux1.tamanho();
            for(int i = 0; i < tamanhoReal;i++)
            {
                enfileirar((int)aux1.desenfileirar()); //jogando ele na nova fila
            }
        }
        //reatribuindo os ponteiros
        tamanhoReal = aux2.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)aux2.desenfileirar()); //jogando ele na nova fila
        }

    }

    public void remover(int pos)
    {
        Queue novaFila = new Queue();

        for(int i = 0; i < pos;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando ele na nova fila
        }
        desenfileirar();
        int tamanhoReal = tamanho;
        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando ele na nova fila
        }
        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }

    }
    public int indice(int v)
    {
        Queue novaFila = new Queue(); //nova fila criada
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        int cont = 0;
        boolean achou = false;
        for(int i = 0; i < tamanhoReal;i++)
        {
            int num = (int)desenfileirar(); //Uso de casting para armazenar o número
            if(num == v)
            {
                novaFila.enfileirar(num);
                achou = true;
                break;
            }
            cont++;
            novaFila.enfileirar(num); //jogando ele na nova fila
        }
        tamanhoReal = tamanho;

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando ele na nova fila
        }

        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
        if(achou)
            return cont;
        return -1;
    }
    public void esvaziar()
    {
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        for(int i = 0; i < tamanhoReal;i++)
        {
            desenfileirar(); //Uso de casting para armazenar o número
        }
    }
    public int[] array()
    {
        Queue novaFila = new Queue(); //nova fila criada
        int[] vetorAux = new int [tamanho];
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        for(int i = 0; i < tamanhoReal;i++)
        {
            int num = (int)desenfileirar(); //Uso de casting para armazenar o número
            novaFila.enfileirar(num); //jogando ele na nova fila
            vetorAux[i] = num;
        }
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
        return vetorAux;
    }
    public boolean pertence(int v)
    {
        Queue novaFila = new Queue(); //nova fila criada
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        boolean achou = false;
        for(int i = 0; i < tamanhoReal;i++)
        {
            int num = (int)desenfileirar(); //Uso de casting para armazenar o número
            if(num == v)
            {
                achou = true;

            }
            novaFila.enfileirar(num); //jogando ele na nova fila
        }

        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
        return achou;
    }
    public void ordenar()
    {
        Queue novaFila = new Queue();
        int num = (int)desenfileirar();
        novaFila.enfileirar(num);
        int tamanhoReal = tamanho;
        int menorElemento = num;
        for(int i = 0;i < tamanhoReal;i++)
        {
            num = (int) desenfileirar();
            if(num < menorElemento)
            {
                menorElemento = num;
                novaFila.addInit(num);
            }
            else
            {
                novaFila.enfileirar(num);
            }
        }
        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }

    }
    private void addInit(int valor)
    {

        Queue novaFila = new Queue(); //nova fila criada
        novaFila.enfileirar(valor); //jogando ele na nova fila

        int tamanhoReal = tamanho; //salvado a quantidade de repetições

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando ele na nova fila
        }
        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
    }
    public void appendArray(int[] v)
    {
        for(int i = 0; i < v.length;i++)
        {
            enfileirar(v[i]);
        }
    }
    public void prependArray(int[] v)
    {
        Queue novaFila = new Queue(); //nova fila criada
        for(int i = 0; i < v.length;i++)
        {
            novaFila.enfileirar(v[i]); //jogando o valor do vetor na nova fila
        }
        int tamanhoReal = tamanho; //salvado a quantidade de repetições restantes

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando o resto na nova fila
        }
        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
    }
    public void inserirFilaPosicao(Queue fila, int pos)
    {
        Queue novaFila = new Queue(); //nova fila criada
        for(int i = 0; i <= pos;i++)
        {
            int num = (int)desenfileirar();
            novaFila.enfileirar(num); //jogando ele na nova fila
        }
        int tam = fila.tamanho;
        for(int i = 0; i < tam; i++)
        {
            int num = (int)fila.desenfileirar();
            novaFila.enfileirar(num);
        }

        int tamanhoReal = tamanho; //salvado a quantidade de repetições restantes

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando o resto na nova fila
        }
        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
    }
    public void inserirArrayPosicao(int[] v, int pos)
    {
        Queue novaFila = new Queue(); //nova fila criada
        for(int i = 0; i <= pos;i++)
        {
            int num = (int)desenfileirar();
            novaFila.enfileirar(num); //jogando ele na nova fila
        }
        int tam = v.length;
        for(int i = 0; i < tam; i++)
        {
            novaFila.enfileirar(v[i]);
        }

        int tamanhoReal = tamanho; //salvado a quantidade de repetições restantes

        for(int i = 0; i < tamanhoReal;i++)
        {
            novaFila.enfileirar((int)desenfileirar()); //jogando o resto na nova fila
        }
        //reatribuindo os ponteiros
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //jogando ele na nova fila
        }
    }

    public boolean vazio()
    {
        return (tamanho() == 0);
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


