var n = parseInt(prompt("Qual o número?"));
var fatorial = 1;
for(i = 1; i <= n;i++)
{
		fatorial*=i; //fatorial = fatorial * i
}
document.write(n+"! é:"+fatorial);