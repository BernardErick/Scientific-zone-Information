using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            int[] vetor = { 10, 12, 20, 23, 27, 30, 31, 39, 42, 44, 45, 49, 57, 63, 70 };
            Console.WriteLine("Qual número você quer achar?");
            int num = int.Parse(Console.ReadLine());
            Achar(vetor, 0, vetor.Length - 1, num);

        }
        static void Achar(int[] vetor, int inicio, int fim,int num)
        {
            if (inicio <= fim)
            {
                int meio = (inicio + fim) / 2;
                if (num == vetor[meio])
                {
                    Console.WriteLine("O número " + num + " ta na posição " + meio);
                }
                if (num > vetor[meio])
                {
                    inicio = meio + 1;
                    Achar(vetor, inicio, fim, num);
                }
                if (num < vetor[meio])
                {
                    fim = meio - 1;
                    Achar(vetor, inicio, fim, num);
                }
            }
            else
            {
                Console.WriteLine("O número " + num + " não existe no vetor!");
            }
        }



    }


}
