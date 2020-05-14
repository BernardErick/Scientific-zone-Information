public class  No
{
    private Disco Dado;
    private No Proximo;

    public No(Disco dado)
    {
        Dado = dado;
    }
    public Disco getDado() {
        return Dado;
    }

    public void setDado(Disco dado) {
        Dado = dado;
    }

    public No getProximo() {
        return Proximo;
    }

    public void setProximo(No proximo) {
        Proximo = proximo;
    }


}