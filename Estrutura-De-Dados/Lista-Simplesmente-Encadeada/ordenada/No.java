  public class No
{
    private int Dado;
    private No Proximo;
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
}