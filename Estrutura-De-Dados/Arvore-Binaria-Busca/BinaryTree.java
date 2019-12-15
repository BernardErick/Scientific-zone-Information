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
    }
    public void add(No raizAux,int valor)//Inserção
    {
        if(valor < raizAux.getDado()) //joga pra esquerda
        {
            if(raizAux.getEsquerdo() == null)//esquerda cheia?
            {
                add(raizAux.getEsquerdo(),valor);
            }
            else//esquerda vazia
            {
                raizAux.setEsquerdo(new No(valor));
            }
        }
        else if(valor > raizAux.getDado()) //joga pra direita
        {
            if(raizAux.getDireito() != null) //direita cheia?
            {
                add(raizAux.getDireito(),valor);
            }
            else//direita vazia
            {
                raizAux.setDireito(new No(valor));
            }
        } 
        tamanho++;
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
    public boolean search(No raizAux,int valor)//Busca
    {
        if(valor == raiz.getDado())
        {
            return true;
        }
        else
        {
            if(valor < raizAux.getDado()) //cai na esquerda
            {
                if(raiz.getEsquerdo() == null) //é igual ao valor que eu quero?
                {
                    return false;
                }
                else
                {
                	return search(raiz.getEsquerdo(),valor);
                }
            }
            else if(valor > raizAux.getDado())//cai na direita
            {
                if(raiz.getDireito() == null)//é igual ao valor que eu quero?
                {
                    return false;
                }
                else
                {
                    return search(raiz.getDireito(),valor);
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
    	else 
    	{
    		System.out.println("sem raizes!");
    	}
    }
    public void printPreOrdem(No raizAux)
    {
            System.out.print(raizAux.getDado() + " "); //visita

            if(raizAux.getEsquerdo() != null) //percorre a esquerda
            {
                printPreOrdem(raizAux.getEsquerdo());
            }
            else if(raizAux.getDireito() != null) //percorre a direita
            {
                printPreOrdem(raizAux.getDireito());
            }
    }
    //---------------------------------------------------
    public void printEmOrdem() {
		if (raiz != null) 
		{
			printEmOrdem(raiz);
			System.out.println();
		}
		else 
		{
			System.out.println("sem raizes!");
		}
	}

	public void printEmOrdem(No raiz) 
	{
		if (raiz.getEsquerdo() != null) {
			printEmOrdem(raiz.getEsquerdo());
		}

		System.out.print(raiz.getDado() + " ");

		if (raiz.getDireito() != null) 
		{
			printEmOrdem(raiz.getDireito());
		}
	}
	//---------------------------------------------------
	public void printPosOrdem() 
	{
		if (raiz != null) {
			printPosOrdem(raiz);
			System.out.println();
		}
		else 
		{
			System.out.println("Sem raizes!");
		}		
	}
	public void printPosOrdem(No raiz) 
	{
		if (raiz.getEsquerdo() != null) 
		{
			printPosOrdem(raiz.getEsquerdo());
		}
		if (raiz.getDireito() != null) {
			printPosOrdem(raiz.getDireito());
		}

		System.out.print(raiz.getDado() + " ");
	} 
	

}
