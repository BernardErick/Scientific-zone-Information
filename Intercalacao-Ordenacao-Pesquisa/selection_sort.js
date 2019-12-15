
var vetor = [20, 35, 18, 8, 14, 41, 3, 39]; //O objetivo é verificar no vetor o menor valor e passar ele para a primeira posição
console.log("Antes das repetições o vetor é: "+vetor);
console.log("");
for(var i = 0; i < vetor.length-1;i++)
{
	var menor = vetor[i];
	var posicaoMenor = i;
	for(var z = i+1;z < vetor.length;z++)
	{
		if(vetor[z] < menor)
		{
			menor = vetor[z];
			posicaoMenor = z;
		}
	}
	vetor[posicaoMenor] = vetor[i];
	vetor[i] = menor;
	console.log("Na "+i+"º repetição o menor valor é : "+menor); 
	console.log("	E o vetor ficou: "+vetor);
}
document.write(vetor);
