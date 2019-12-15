
var vetor = [10,12,20,23,27,30,31,39,42,44,45,49,57,63,70];
var num = parseInt(prompt("Digite o número que você quer achar: "));
function achar(vetor,inicio,fim) //recursividade
{
	if(inicio <= fim)
	{
		let meio = Math.floor((inicio+fim)/2);
		if(num == vetor[meio])
		{
			document.write("O número "+num+" ta na posição "+meio);
		} 
		if(num > vetor[meio])
		{
			inicio = meio + 1;
			achar(vetor,inicio,fim);
		}
		if(num < vetor[meio])
		{
			fim = meio - 1;
			achar(vetor,inicio,fim);
		}
	}
	else
	{
		document.write("O número "+num+" não existe no vetor!");
	}
}
achar(vetor,0,vetor.length-1);

