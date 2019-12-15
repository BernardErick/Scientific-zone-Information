
public class  No
{
	private int Dado;
	private No  Proximo;
	private No  Anterior;
	
	public No(int dado)
	{
		Dado = dado;
	}
	public int getDado() {
		return Dado;
	}

	public void setDado(int dado) {
		Dado = dado;
	}

	public No getProximo() {
		return Proximo;
	}

	public void setProximo(No proximo) {
		Proximo = proximo;
	}
	public No getAnterior() {
		return Anterior;
	}
	public void setAnterior(No anterior) {
		Anterior = anterior;
	}

}
