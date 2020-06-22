public class BinaryTree
{
    private No raiz;
    private int tamanho;
    public BinaryTree()
    {
        raiz = null;
        tamanho = 0;
    }
    //------------------------------------------------------
    public void add(int valor)
    {
        if(raiz == null)
        {
            raiz = new No(valor);
        }
        else
        {
            add(raiz,valor);
        }
        tamanho++;
    }
    public void add(No raiz,int valor)//Inserção
    {
        if(valor < raiz.dado) //joga pra esquerda
        {
            if(raiz.esquerda == null)
            {
                raiz.esquerda = new No(valor);
            }
            else
            {
                add(raiz.esquerda,valor);
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
                add(raiz.direita,valor);
            }
        }
    }
    //--------------------------------------------------------
    public boolean search(int valor)
    {
        if(raiz == null)
        {
            return false;
        }
        else
        {
            return search(raiz,valor);
        }
    }
    public boolean search(No raiz,int valor)//Busca
    {
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
                   search(raiz.esquerda,valor);
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
                    search(raiz.direita,valor);
                }
            }
        }
        return false;
    }
    //-----------------------------------------------------
    public void printPreOrdem()
    {
        if (raiz != null) {
            printPreOrdem(raiz);
            System.out.println();
        }
    }
    public void printPreOrdem(No raiz)
    {
        System.out.print(raiz.dado + " "); //visita

        if(raiz.esquerda != null) //percorre a esquerda
        {
            printPreOrdem(raiz.esquerda);
        }
        else if(raiz.direita != null) //percorre a direita
        {
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

    public void printEmOrdem(No raiz)
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
    public void printPosOrdem(No raiz)
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
    public int menorValor(No raiz) {
        if (raiz.esquerda == null)
            return raiz.dado;
        else
            return menorValor(raiz.esquerda);
    }
    //---------------------------------------------------
    public void remover(int valor) {
        if (raiz != null) {
            remover(valor, raiz, null);
        }
        tamanho--;
    }

    public void remover(int valor, No raiz, No pai) {
        if (valor == raiz.dado)
        {
            if (raiz.esquerda == null && raiz.direita == null) {      // Nó não tem filhos
                if (raiz == pai.esquerda)    // Nó é filho esquerdo?
                    pai.esquerda = null;
                else
                    pai.direita = null;
            }
            else if (raiz.esquerda != null && raiz.direita == null) { // Nó tem um filho (esquerdo)
                if (raiz == pai.esquerda)    // Nó é filho esquerdo?
                    pai.esquerda = raiz.esquerda;
                else
                    pai.direita = raiz.esquerda;
            }
            else if (raiz.esquerda == null && raiz.direita != null) { // Nó tem um filho (direito)
                if (raiz == pai.esquerda)    // Nó é filho esquerdo?
                    pai.esquerda = raiz.direita;
                else
                    pai.direita = raiz.direita;
            }
            else if (raiz.esquerda != null && raiz.direita != null) { // Nó tem dois filhos
                raiz.dado = menorValor(raiz.direita);
                remover(raiz.dado, raiz.direita, raiz);
            }
        }
        else if (valor < raiz.dado) {
            if (raiz.esquerda != null)
                remover(valor, raiz.esquerda, raiz);
        }
        else if (valor > raiz.dado) {
            if (raiz.direita != null)
                remover(valor, raiz.direita, raiz);
        }
    }


}
