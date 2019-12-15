//Função fatorial
function fatorial(n){
var fat = 1;
for(var i = 1; i <= n;i++)
{
		fat*=i; //fatorial = fatorial * i
}
return fat;
}
//Algoritmo

var x = prompt("informe o X:");
var n = prompt("Quantidade de termos");

var termo;
var sinal = 1;
var j = 1;
var seno = 0;

for(var i = 1; i <= n; i++)
{
	termo = Math.pow(x,j)/fatorial(j);
	seno = seno + sinal * termo;
	sinal = sinal * - 1;
	j+=2;
}
document.write("sen(x) = "+seno);







