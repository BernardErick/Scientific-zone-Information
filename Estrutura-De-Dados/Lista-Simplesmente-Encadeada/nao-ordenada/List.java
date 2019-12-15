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
	
	public void Add(int valor)
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
	public void AddInit(int valor) 
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
