
public class Stack <T>
{
	private No primeiro;
	private No ultimo;
	private int tamanho;
	
	public Stack() 
	{
		primeiro = null;
		ultimo = null;
		tamanho = 0;
	}

	public void Push(T valor) // 5  6
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
			novo.setAnterior(ultimo);
			ultimo = novo;
		}
		tamanho++;
	}	
	public void Pop() 
	{
		No aux = ultimo;
		aux.getAnterior().setProximo(null);
		ultimo = aux.getAnterior();
		tamanho--;
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
	public boolean Find(T valor) 
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
