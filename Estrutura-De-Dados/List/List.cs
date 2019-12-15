using System;
using System.Collections.Generic;
using System.Text;

namespace CursoProg
{
    class List
    {
        private No primeiro;
        private No ultimo;
        private int tamanho { get; set; }

        public List()
        {
            primeiro = null;
            ultimo = null;
            tamanho = 0;
        }
        public void addInicio(Produto valor)// adiciona um elemento a primeira posição
        {
            No novo = new No(valor);

            if (primeiro == null)
            {
                primeiro = novo;
                ultimo = novo;
            }
            else
            {
                novo.Proximo = primeiro;
                primeiro = novo;
            }
            tamanho++;
        }
        public void addFim(Produto valor) // adiciona um elemento a ultima posição
        {
            No novo = new No(valor);

            if (primeiro == null)
            {
                primeiro = novo;
                ultimo = novo;
            }
            else
            {
                ultimo.Proximo = novo;
                ultimo = novo;
            }

            tamanho++;
        }
        public void Get() //exibe a lista
        {
            No aux = primeiro;

            while (aux != null)
            {
                Console.Write("Dado:"+aux.Dado.Codigo+", "+aux.Dado.Preco+", "+aux.Dado.Quantidade+" ");
                Console.WriteLine();
                aux = aux.Proximo;
            }
        }
        public void ModificarPreco(int valor)
        {
            No aux = primeiro;
            while (aux != null)
            {
                aux.Dado.Preco -= aux.Dado.Preco * valor / 100;
                aux = aux.Proximo;
            }
        }
        public int Superior(int max)
        {
            int quant = 0;
            No aux = primeiro;
            while (aux != null)
            {
                if (aux.Dado.Preco > max)
                {
                    quant++;                   
                }
                aux = aux.Proximo;
            }
            return quant;
        }
    }
}
