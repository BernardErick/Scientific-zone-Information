
var vetor = [10, 12, 20, 23, 27, 30, 31, 39, 42, 44, 45, 49, 57, 63, 70];

var inicio = 0;
var fim = vetor.length - 1;
var meio;

var num = prompt("Informe o número a ser pesquisado:");

while (inicio <= fim) 
{
    meio = Math.floor((inicio + fim)/2);

    if (num == vetor[meio]) 
	{
        break;
    }

    if (num > vetor[meio]) 
	{
        inicio = meio + 1;
    }

    if (num < vetor[meio]) 
	{
        fim = meio - 1;
    }
}

if (num == vetor[meio]) 
{
    document.write("O número " + num + " está na posição " + meio);
}
else 
{
    document.write("O número " + num + " não está no vetor.");
}
