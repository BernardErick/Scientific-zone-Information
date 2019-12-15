var vetor = [2,3,4,5,6,7,8,9];
var aux;
var vetorSize = vetor.length;
document.write("Nº original: "+vetor+"<br>");
for(i = 0;i < vetorSize/2 ;i++)
{
	aux = vetor[i];
	vetor[i] = vetor[vetorSize - 1 - i];
	vetor[vetorSize - 1 - i] = aux;
}
document.write("Nº invertido: "+vetor);
// (vetorSize - 1) == ultimo indice do vetor;
// o -i representa o decressimo do ultimo indice;
// a aux salva o valor do indice antes dele se alterar;