using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            int[] vector = new int[] {2,1,7,0};
            Console.WriteLine("Com iteração: "+Max_inte(vector));
            Console.WriteLine("Sem iteração: "+Max(vector,4));
        }
        static int Max_inte(int[] vetor)
        {
            int maiorNumero = vetor[0]; //o maior número começa com um valor aleatório.

            for (int j = 1; j < vetor.Length; j++)
            {
                if (vetor[j] > maiorNumero) //se outro valor for maior q ele.
                {
                    maiorNumero = vetor[j]; //ele se torna o maior número.
                }

            }
            return maiorNumero;
        }
        static int Max(int[] vetor, int n) 
        {
            int Maior;
            if (n == 1)
            {
                Maior = vetor[0];
            }
            else
            {
                Maior = Max(vetor, n - 1);  
                if (vetor[n - 1] > Maior) 
                {
                    Maior = vetor[n - 1];
                }
            }
            
            return Maior;
        }
    }


}
