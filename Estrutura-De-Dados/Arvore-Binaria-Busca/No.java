public class No
{
    private int dado;
    private No Esquerdo;
    private No Direito;
    public No(int dado)
    {
        this.dado = dado;
    }
    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getEsquerdo() {
        return Esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        Esquerdo = esquerdo;
    }

    public No getDireito() {
        return Direito;
    }

    public void setDireito(No direito) {
        Direito = direito;
    }
}
