import java.util.ArrayList;
import java.util.Scanner;

public class Hanoi
{
    private Stack[] hastes;
    private Disco[] discos;
    private int movimentos;

    Scanner dado = new Scanner(System.in);
    public Hanoi(int quantDiscos)
    {
        //verificando se o numero de discos é maior ou igual a 2
        while(quantDiscos < 2)
        {
            System.out.println("Quantidade de discos invalida!");
            System.out.println("Digite um valor maior ou igual a 2 :");
            quantDiscos = dado.nextInt();
        }
        //criando hastes,discos,movimentos
        hastes = new Stack[3];
        discos = new Disco[quantDiscos];
        movimentos = (int)(Math.pow(2,quantDiscos) - 1);
        //Instanciando cada haste como pilha para receber os discos
        for(int i =0;i < 3;i++)
        {
            hastes[i] = new Stack();
        }
        //Instanciando o disco e colocando na haste de origem
        //Adicionando primeiro os maiores discos(PILHA)
        for(int i = quantDiscos -1; i >= 0;i--)
        {
            String id = "id";

            discos[i] = new Disco(id+(i + 1), i +1 );

            hastes[0].push(discos[i]);
        }

    }
    public void movimentos()
    {
        System.out.println("Total de movimentos: "+movimentos);
    }
    public void exibirMovimento(int mov)
    {
        System.out.println("Movimento número: "+mov+" ----->");
        for(int i = 0 ; i < 3;i++)
        {
            System.out.println();
            if(!hastes[i].isNull())
            {
                hastes[i].show();
            }
            else
            {
                System.out.println("_I_");
            }
            System.out.println();

        }
    }
    public boolean moverDisco(int origem,int destino)
    {
        if(hastes[destino].isNull())
        {
            hastes[destino].push(hastes[origem].pop());
            return true;
        }
        else
        {
            Disco auxTemp = hastes[origem].pop();
            if(hastes[destino].peek().raio > auxTemp.raio)
            {
                hastes[destino].push(auxTemp);
                return true;
            }
            else
            {
                hastes[origem].push(auxTemp);
                return false;
            }
        }
    }
    public void iniciaHanoi()
    {
        if(discos.length % 2 != 0) //Impar
        {
            for(int i = 1; i <= movimentos;i++)
            {
                if(i % hastes.length == 1)
                {
                    //origem para destino
                    if(hastes[0].isNull()) //se Origem esta vazia ja mande invertido
                    {
                        moverDisco(2,0); //Destino --> Origem
                    }
                    else
                    {
                        if(!moverDisco(0,2)) //Origem ==> Destino
                        {
                            moverDisco(2,0); //Destino --> Origem
                        }
                    }

                    exibirMovimento(i);
                }
                if(i % hastes.length == 2)
                {
                    //origem para auxiliar
                    if(hastes[0].isNull()) //se origem esta vazia ja manda invertido
                    {
                        moverDisco(1,0); //Aux --> Origem
                    }
                    else
                    {
                        if(!moverDisco(0,1)) //Origem --> Aux
                        {
                            moverDisco(1,0); //Aux --> Origem
                        }
                    }
                    exibirMovimento(i);
                }
                if(i % hastes.length == 0)
                {
                    if(hastes[1].isNull()) //se a Aux esta vazia ja inicia invertido
                    {
                        moverDisco(2,1); //Destino --> Aux
                    }
                    else
                    {
                        if(!moverDisco(1,2) ) //Aux --> Destino
                        {
                            moverDisco(2,1); //Destino --> Aux
                        }
                    }
                    exibirMovimento(i);
                }
            }
        }
        if(discos.length % 2 == 0) //Pares
        {
            for(int i = 1; i <= movimentos;i++)
            {
                if(i % hastes.length == 1)
                {
                    //origem para destino
                    if(hastes[0].isNull()) //se Origem esta vazia ja mande invertido
                    {
                        moverDisco(1,0); //Aux --> Origem
                    }
                    else
                    {
                        if(!moverDisco(0,1)) //Origem ==> Aux
                        {
                            moverDisco(1,0); //Aux --> Origem
                        }
                    }

                    exibirMovimento(i);
                }
                if(i % hastes.length == 2)
                {
                    //origem para auxiliar
                    if(hastes[0].isNull()) //se origem esta vazia ja manda invertido
                    {
                        moverDisco(2,0); //Destino --> Origem
                    }
                    else
                    {
                        if(!moverDisco(0,2)) //Origem --> Destino
                        {
                            moverDisco(2,0); //Destino --> Origem
                        }
                    }
                    exibirMovimento(i);
                }
                if(i % hastes.length == 0)
                {
                    if(hastes[2].isNull()) //se o Destino esta vazia ja inicia invertido
                    {
                        moverDisco(1,2); //Aux --> Destino
                    }
                    else
                    {
                        if(!moverDisco(2,1) ) //Destino --> Aux
                        {
                            moverDisco(1,2); //Aux --> Destino
                        }
                    }
                    exibirMovimento(i);
                }
            }
        }

    }

}
