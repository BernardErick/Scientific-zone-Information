public class BinaryTree
{
    private No raiz;
    public BinaryTree()
    {
        raiz = null;
    }
    public BinaryTree(int[] array)
    {
        BinaryTreeArray(array,0);
    }
    private void BinaryTreeArray(int[] array, int i)
    {
        if (i < array.length)
        {
            adicionar(array[i]);
            BinaryTreeArray(array,i+1);
        }
    }

    public BinaryTree(BinaryTree tree)
    {
        int[] array = tree.array();
        BinaryTreeArray(array,0);
    }

    //------------------------------------------------------
    public void adicionar(int valor)
    {
        if(raiz == null)
        {
            raiz = new No(valor);
        }
        else
        {
            adicionar(raiz,valor);
        }
    }
    private void adicionar(No raiz,int valor)//Inserção
    {
        if(valor < raiz.dado) //joga pra esquerda
        {
            if(raiz.esquerda == null)
            {
                raiz.esquerda = new No(valor);
            }
            else
            {
                adicionar(raiz.esquerda,valor);
            }
        }
        else if(valor > raiz.dado) //joga pra direita
        {
            if(raiz.direita == null)
            {
                raiz.direita = new No(valor);
            }
            else//direita vazia
            {
                adicionar(raiz.direita,valor);
            }
        }
    }
    //--------------------------------------------------------
    public boolean pertence(int valor)
    {
        if(raiz == null)
        {
            return false;
        }
        else
        {
            return pertence(raiz,valor);
        }
    }
    private boolean pertence(No raiz,int valor)//Busca
    {
       /*
                  50
               /     \
              30      70
             /  \    /  \
            20   40  60   80
       */
        if(valor == raiz.dado)
        {
            return true;
        }
        else
        {
            if(valor < raiz.dado)
            {
                if(raiz.esquerda == null)
                {
                    return false;
                }
                else
                {
                   pertence(raiz.esquerda,valor);
                }
            }
            else if(valor > raiz.dado)
            {
                if(raiz.direita == null)
                {
                    return false;
                }
                else
                {
                    pertence(raiz.direita,valor);
                }
            }
        }

        return false;
    }
    //-----------------------------------------------------
    public void printPreOrdem() {
        if (raiz != null) {
            printPreOrdem(raiz);
            System.out.println();
        }
    }

   private void printPreOrdem(No raiz) {
        System.out.print(raiz.dado + " ");

        if (raiz.esquerda != null) {
            printPreOrdem(raiz.esquerda);
        }

        if (raiz.direita != null) {
            printPreOrdem(raiz.direita);
        }
    }

    //---------------------------------------------------
    public void printEmOrdem() {
        if (raiz != null)
        {
            printEmOrdem(raiz);
            System.out.println();
        }
    }

    private void printEmOrdem(No raiz)
    {
        if (raiz.esquerda != null) {
            printEmOrdem(raiz.esquerda);
        }

        System.out.print(raiz.dado + " ");

        if (raiz.direita != null)
        {
            printEmOrdem(raiz.direita);
        }
    }
    //---------------------------------------------------
    public void printPosOrdem()
    {
        if (raiz != null) {
            printPosOrdem(raiz);
            System.out.println();
        }
    }
    private void printPosOrdem(No raiz)
    {
        if (raiz.esquerda != null)
        {
            printPosOrdem(raiz.esquerda);
        }
        if (raiz.direita != null) {
            printPosOrdem(raiz.direita);
        }

        System.out.print(raiz.dado + " ");
    }
    //----------------------------------------------------
    private int menorValor(No raiz) {
        if (raiz.esquerda == null)
            return raiz.dado;
        else
            return menorValor(raiz.esquerda);
    }
    //---------------------------------------------------
    public void remover(int valor)
    {
        raiz = remover(raiz,valor);
    }
    private No remover(No raiz,int valor)
    {
        if (raiz == null) //Se a arvore tiver vazia
        {
            return raiz;
        }
        if (valor < raiz.dado) //Se o valor for menor que o valor da raiz atual percorra a esquerda
        {
            raiz.esquerda = remover(raiz.esquerda,valor);
        }
        else if (valor > raiz.dado)//Se o valor for maior que o valor da raiz atual percorra a direita
        {
            raiz.direita = remover(raiz.direita, valor);
        }
        else //Se o valor é igual ao valor do no dessa raiz, entao o No a ser removido foi achado
        {
            //condições em caso de um filho ou nenhum
            if (raiz.esquerda == null)
                return raiz.direita;
            else if (raiz.direita == null)
                return raiz.esquerda;

            raiz.dado = menorValor(raiz.direita); //joga o menor valor das raizes abaixo(se tiver) para onde foi removido
            remover(raiz.direita, raiz.dado); //vai atualizar o menor no repetido que subiu
            /*
                              50
                           /     \
                          30      70
                         /  \    /  \
                        20   40  60   80
            */

        }

        //na pior das hipoteses esse return leva a arvore q nao achou o valor buscado e ao mesmo tempo se for alterado
        return raiz;

    }
    //---------------------------------------------------
    public int tamanho()
    {
        return tamanho(raiz);
    }
    private int tamanho(No raiz)
    {
        if (raiz == null)
            return 0;
        else
            {
            int conte = tamanho(raiz.esquerda);
            int contd = tamanho(raiz.direita);
            return conte + contd + 1;
        }

    }
    //

    //----------------------------------------
    public int nivel(int dado)
    {
        return nivel(raiz, dado, 1);
    }
    private int nivel(No raiz, int dado, int nivel)
    {
        /*
                      50             1
                   /     \
                  30      70         2
                 /  \    /  \
                20   40  60   80     3
        */
        if (raiz == null)
            return 0;

        if (raiz.dado == dado)
            return nivel;

        int nivelBaixo = nivel(raiz.esquerda, dado, nivel + 1);

        if (nivelBaixo != 0)
            return nivelBaixo;

        nivelBaixo = nivel(raiz.direita, dado, nivel + 1);
        return nivelBaixo;
    }

    public int[] array()
    {
        int [] array = new int[tamanho(raiz)];
        array(raiz, array,0);
        return array;
    }
    private int array(No raiz, int [] array, int i )
    {
        if(i < array.length)
        {
            if(raiz.esquerda!=null)
            {
                i = array(raiz.esquerda,array,i);
            }
            array[i] = raiz.dado;
            i++;
            if(raiz.direita!=null)
            {
                i =  array(raiz.direita,array,i);
            }
        }

        return i;
    }






}
