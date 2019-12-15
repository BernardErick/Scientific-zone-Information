
var vetor = [20,35,18,8,14,41,3,39];
var aux;
var p; //posição

for(var i = 1;i<vetor.length;i++) // usa-se 1 pois o vetor[0] ja esta ordenado
{
	aux = vetor[i];
	p = i;
	while(p > 0 && vetor[p-1] > aux) //enquanto o antecessor dele for maior que ele
	{
		vetor[p] = vetor[p-1];
		p--;
	}
	vetor[p] = aux; //depois de passar os antecessores maiores que o indice analisado, vai jogar ele na posição que sobrou
}


document.write(vetor);










