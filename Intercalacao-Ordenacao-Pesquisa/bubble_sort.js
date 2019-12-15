
var vetor = [60, 35, 18, 8, 14, 41, 3, 60 , 80 , 90 , 20 , 51 , 60 , 30 , 5 , 63 , 2 , 30 , 5];
var aux;
for(var i = 0; i < vetor.length -1;i++)
{
	for(var z = 0; z < vetor.length -1 - i;z++)
	{
		if(vetor[z] > vetor[z+1])   
		{			
			aux = vetor[z];
			vetor[z] = vetor[z+1];
			vetor[z+1] = aux;
		}
	}
}

document.write(vetor);
