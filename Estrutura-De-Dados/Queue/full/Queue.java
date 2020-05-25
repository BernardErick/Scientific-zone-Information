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
    public void enfileirar(int valor) //adiciona elementos(Fila)
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

    public Object desenfileirar() //remove elementos(Fila)
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
    public void exibir() //exibe os elementos
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
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
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
            //normalizando a fila
            tamanhoReal = novaFila.tamanho();
            for(int i = 0; i < tamanhoReal;i++)
            {
                enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
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

        //normalizandoa fila
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
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
            for(int i = 0; i <= pos;i++) //percorrendo ate a posicao do parametro
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
            //normalizando a fila
            tamanhoReal = novaFila.tamanho();
            for(int i = 0; i < tamanhoReal;i++)
            {
                enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
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

        //normalizando a fila
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
        }


    }

    public No clonar() //Kage bunshin no Jutsu
    {
        //algumas observações sobre esse metodo
        //diferente do primeiro que podia manipular os ponteiros
        //esse foi feito usando o desenfileiramento e enfileiramento da pilha principal

        Queue novaFila = new Queue(); //nova fila criada

        //aqui vai ser inicializado logo por conta do No exigir 1 paramentro
        int n = (int)desenfileirar();
        No clone = new No(n);
        novaFila.enfileirar(n);
        //aqui foi criado uma variavel aux pra ajudar a preencher o clone sem que o clone perca a referencia do inicio
        No aux = clone;
        int tamanhoReal = tamanho; //salvado a quantidade de repetições
        for(int i = 0; i < tamanhoReal;i++)
        {
            int num = (int)desenfileirar(); //Uso de casting para armazenar o número
            //criando um novo No temporario para ser adicionado ao clone
            No novo = new No(num);
            aux.setProximo(novo);
            aux = aux.getProximo();
            //e depois adicionando na novaFila normalmente
            novaFila.enfileirar(num); //jogando ele na nova fila
        }
        //normalizando a fila
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
        }
        //retornando um No com uma copia de todos os elementos
        return clone;
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

        //normalizando a fila
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
        }
        return cont;
    }
    public void inverter()
    {
        /*
        * uma breve explicação da mecanica do metodo:
        *
        * 1 passo) Inicialmente o que existe
        * lista[1 , 2 , 3 , 4]
        * aux1 []
        * aux 2 []
        *
        * 2 passo) Desenfileirar os elementos da Lista para a aux 1 deixando somente o ultimo elemento
        * Lista[X , X , X , 4]
        * aux1[1 , 2 , 3]
        * aux[]
        *
        * 3 passo) Desenfileirar o ultimo Elemento da Lista na aux 2
        * Lista[X , X , X , X]
        * aux1[1, 2 , 3 ]
        * aux2[4]
        *
        * 4 passo) Atribuir a aux1 sendo a nova Lista e criando uma nova aux1
        * Lista[1, 2 , 3]
        * aux1 []
        * aux2[4 ]
        *
        * 5 passo) Repetir o mesmo processo ate que a aux2 tenha sido preenchida com todos elementos da Lista invertidos
        * Lista[X, X , 3]
        * aux1[1 , 2]
        * aux2[4 ]
        *
        * ...
        *
        * 6 passo) Depois que a aux2 estiver cheia, desemfileirar o aux2 de volta na Lista Original que estava nula
        * Lista[]
        * aux1[]
        * aux2[4 , 3 , 2 , 1]
        *
        * por fim)
        * Lista[4 , 3 , 2 , 1]
        *
        * */
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
                enfileirar((int)aux1.desenfileirar()); //desenfileirando a aux1 na FilaOriginal
            }
        }
        //normalizando a fila
        tamanhoReal = aux2.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)aux2.desenfileirar()); //desenfileirando a aux2 na FilaOriginal
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
        //normalizando a fila
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
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

        //normalizando a fila
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
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
            desenfileirar();
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
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
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

        //normalizando
        tamanhoReal = novaFila.tamanho();
        for(int i = 0; i < tamanhoReal;i++)
        {
            enfileirar((int)novaFila.desenfileirar()); //desenfileirando a novaFila na FilaOriginal
        }
        return achou;
    }
    public void ordenar()
    {
        List lista = new List();
        int tamanhoReal = tamanho;
        for(int i = 0; i<tamanhoReal;i++)
        {
            lista.prepend((int)desenfileirar());
        }
        lista.ordenar();
        int listaReal = lista.tamanho();
        for(int z = 0; z<tamanhoReal;z++)
        {
            int n = lista.removeEnd();
            System.out.println("removendo numero:"+n);
            enfileirar(n);
        }
        inverter();
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
