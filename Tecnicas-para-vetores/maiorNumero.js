var numeros = [];
//Algoritmo de entrada

var qtd = parseInt(prompt("Quantos números você dira?"));
for(i = 1;i <= qtd;i++)
{
	var num = parseInt(prompt("Qual vai ser o "+i+" º número?"));
	numeros.push(num);
}
//Algoritmo de analise do maior numero

var maiorNumero = numeros[0]; //o maior número começa com um valor aleatório.

for(j = 1;j < numeros.length;j++)
{
	if(numeros[j] > maiorNumero) //se outro valor for maior q ele.
	{
		maiorNumero = numeros[j]; //ele se torna o maior número.
	}
	
}
document.write("O maior número é:"+maiorNumero);