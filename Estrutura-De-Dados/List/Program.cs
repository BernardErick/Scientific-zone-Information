using System;
using System.Globalization;
using System.Collections.Generic;

namespace CursoProg
{
    class Program 
    {
        static void Main(string[] args) //Main
        {
            List list = new List();
            for (int i = 0; i < 5; i++)
            {
                Console.Write("Digite o código do Produto:");
                int codigo = int.Parse(Console.ReadLine());
                Console.Write("Digite o preço do Produto: ");
                double preco = double.Parse(Console.ReadLine());
                Console.Write("Digite a quantidade do Produto:");
                int quant = int.Parse(Console.ReadLine());
                list.addInicio(new Produto(codigo, preco, quant));
                Console.WriteLine();
            }
            Console.WriteLine("Dados atualizados:");
            list.Get();
            Console.WriteLine();
            Console.WriteLine("Digite a taxa de desconto:");
            int taxa = int.Parse(Console.ReadLine());
            list.ModificarPreco(taxa);
            Console.WriteLine("Dados atualizados:");
            list.Get();
            Console.WriteLine();
            Console.WriteLine("Quantidade de produtos com preço acima de 500:"+list.Superior(500));

        }      

    }
}


