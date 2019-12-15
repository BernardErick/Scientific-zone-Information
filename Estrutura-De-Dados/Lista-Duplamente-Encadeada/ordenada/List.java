
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
	public void addOrdenado(int valor) //SE QUISER ORDENAR NA HORA DE ADICIONAR
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
		else if (valor <= primeiro.getDado())
        {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo); //5 - 9 - 1
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
	                    novo.setAnterior(temp);
	                    novo.setProximo(p);
	                    p.setAnterior(novo);
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
                novo.setAnterior(temp);
                ultimo = novo;
            }
		}
		tamanho++;
	}
	public void GetPeloUltimo()
	{
		No aux = ultimo;
		int i = tamanho-1;
		while(aux != null) 
		{
			System.out.println("Dado "+i+": "+aux.getDado());
			i--;
			aux = aux.getAnterior();
		}
	}
	public void GetPeloPrimeiro() 
	{
		No aux = primeiro;
		int i = 0;
		while(aux != null) 
		{
			System.out.println("Dado "+i+": "+aux.getDado());
			i++;
			aux = aux.getProximo();
		}
	}
	public void remove(int pos) 
	{
		No ant = null;
		No aux = primeiro;
		int i = 0;
		while(i < pos) 
		{
			ant = aux;
			aux = aux.getProximo();
			i++;
		}
		ant.setProximo(aux.getProximo());
		aux.getProximo().setAnterior(ant);
		aux.setProximo(null);
		aux.setAnterior(null);
		tamanho--;
	}
	public void removeNoFim() 
	{
		No aux = ultimo;
		aux.getAnterior().setProximo(null);
		ultimo = aux.getAnterior();
		tamanho--;
	}
	public void removeNoInicio() 
	{
		No aux = primeiro;
		aux.getProximo().setAnterior(null);
		primeiro = aux.getProximo();
		tamanho--;
		
	}
	public void inserirNaPos(int pos, int valor)
	{
		No aux = primeiro;
		No novo = new No(valor);
		int i = 0;
		while(i < pos)
		{
			aux = aux.getProximo();
			i++;
		}
		aux.getAnterior().setProximo(novo);
		novo.setAnterior(aux.getAnterior());
		novo.setProximo(aux);
		aux.setAnterior(novo);
		tamanho++;
	}
	public void zerarLista() 
	{
		No aux = primeiro;
		No aux2 = ultimo;
		while(aux != null) 
		{
			aux.setProximo(null);
			aux2.setAnterior(null);
			aux = aux.getProximo();
			aux2 = aux2.getAnterior();
			tamanho--;
		}
		primeiro = null;
		ultimo = null;
		System.out.println("Lista vazia!");
	}
	public boolean Find(int valor) 
	{
		No aux = primeiro;
		boolean existe = false;
		while(aux != null)
		{
			if(valor == aux.getDado())
			{
				existe = true;
				break;
			}
			aux = aux.getProximo();
		}
		return existe;
	}
	public void FindPos(int pos)
	{
		No aux = primeiro;
		int i = 0;
		if(pos >= 0 && pos < tamanho) 
		{
			while(i < pos) 
			{
				aux = aux.getProximo();
				i++;
			}
			if(aux != null)
			{
				System.out.println(aux.getDado());
			}
		}
		else 
		{
			System.out.println("Posição não existente!");
		}
	}
	public No FindNoPorPos(int pos) 
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
	
	public boolean isNull() 
	{
		if(primeiro == null) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public int Tamanho() 
	{
		return tamanho;
	}
}
