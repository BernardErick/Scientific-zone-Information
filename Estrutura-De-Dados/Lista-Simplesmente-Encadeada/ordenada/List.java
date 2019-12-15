public class List 
{
	private No primeiro;
	private No ultimo;
	private int tamanho;
	
	public List() 
	{
		primeiro = null;
		ultimo = null;
		tamanho = 0;
	}
	public void sortList() //SE QUISER ORDENAR POR FUNÇÃO
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
	
	public void AddOrdenado(int valor) 
	{
		No novo = new No(valor);
		No temp;
		No p;
		boolean ins = false;
		if(primeiro == null) 
		{
			primeiro = novo;
			ultimo = novo;
		}
		else if(valor <= primeiro.getDado()) 
		{
	 		novo.setProximo(primeiro);
    		primeiro = novo;
		}
		else 
		{
			temp = primeiro;
			p = primeiro.getProximo();
			while(p != null) 
			{
				if(valor >= temp.getDado() && valor <= p.getDado()) //5 - 9 -1
				{
		               		temp.setProximo(novo);
	                    	novo.setProximo(p);
	                    	ins = true;
	                    	break;
				}
        		else
        		{
            			temp = p;
            			p = p.getProximo();
        		}
			}
			if(!ins)
    		{
        		temp.setProximo(novo);
        		ultimo = novo;
    		}
		}
		tamanho++;
	}
	public void get() 
	{
		No aux = primeiro;
		while(aux!= null) 
		{
			System.out.print(aux.getDado()+ " ");
			aux = aux.getProximo();
		}
		System.out.println();
	}
	public void RemoveEnd() 
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
	public void FindPos(int pos) 
	{
		No aux = primeiro;
		int i = 0;
		while(i < pos)
		{
			aux = aux.getProximo();
			i++;
		}
		System.out.println("Valor da pos "+pos+": "+aux.getDado());
	}
	
	
}
