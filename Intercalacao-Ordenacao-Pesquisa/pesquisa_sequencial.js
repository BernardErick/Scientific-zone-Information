
var vetor = [10, 12, 20, 23, 27, 30, 31, 39, 42, 44, 45, 49, 57, 63, 70];

var num = prompt("Informe o número que você quer achar:");

for (var i = 0; i < vetor.length; i++)
{
    if (num == vetor[i]) {
        break;
    }
}

if (num == vetor[i]) 
{
    document.write("O número " + num + " está na posição " + i);
}
else 
{
    document.write("O número " + num+ " não está no vetor!");
}
