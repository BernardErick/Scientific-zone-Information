public class Stack
{
    private No top;
    private int tamanho;

    public Stack()
    {
        top = null;
        tamanho = 0;
    }
    public void push(Disco valor) // 5  6
    {
        No novo = new No(valor);

        novo.setProximo(top);
        top = novo;
        tamanho++;
    }
    public Disco pop()
    {
        if (top != null)
        {
            No item = top;

            top = top.getProximo();
            item.setProximo(null);
            tamanho--;
            return item.getDado();
        }
        tamanho--;
        return null;
    }
    public void show()
    {
        Stack novaPilha = new Stack(); // nova pilha criada
        int tamanhoReal = tamanho; //salvando a quantidade de repetições
        for(int i = 0; i<tamanhoReal;i++)
        {
            Disco disco = (Disco) pop(); // Uso de casting para armazenar o valor
            if(disco != null)
            {
                System.out.println(disco);
            }
            novaPilha.push(disco);
        }
        //reatribuindo os ponteiros
        this.top = novaPilha.getTop();
        tamanho = novaPilha.tamanho();

        //fazendo de novo
        Stack novaPilha2 = new Stack(); // nova pilha criada
        tamanhoReal = tamanho; //salvando a quantidade de repetições
        for(int i = 0; i<tamanhoReal;i++)
        {
            Disco disco = (Disco) pop(); // Uso de casting para armazenar o valor
            novaPilha2.push(disco);
        }
        //reatribuindo os ponteiros
        this.top = novaPilha2.getTop();
        tamanho = novaPilha2.tamanho();
    }
    public boolean isNull()
    {
        return (top == null);
    }
    private No getTop()
    {
        return top;
    }
    public int tamanho()
    {
        return tamanho;
    }
    public Disco peek()
    {
        return top.getDado();
    }
}