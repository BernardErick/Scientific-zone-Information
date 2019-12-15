
public class  No <Tipo> 
{
	private Tipo Dado;
	private No <Tipo> Proximo;
	private No <Tipo> Anterior;
	
	public No(Tipo dado)
	{
		Dado = dado;
	}
	public Tipo getDado() {
		return Dado;
	}

	public void setDado(Tipo dado) {
		Dado = dado;
	}

	public No<Tipo> getProximo() {
		return Proximo;
	}

	public void setProximo(No<Tipo> proximo) {
		Proximo = proximo;
	}
	public No<Tipo> getAnterior() {
		return Anterior;
	}
	public void setAnterior(No<Tipo> anterior) {
		Anterior = anterior;
	}

}
