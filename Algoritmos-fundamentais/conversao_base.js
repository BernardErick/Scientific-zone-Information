var numero = parseInt(prompt("Digite um numero inteiro:"));
var resto = [];
var i = 0;
for(q = numero;q>0;q = Math.floor(q/2))
{
	resto[i]=q%2; //OU resto.push()
	i++
}
document.write("Número em base decimal: "+numero+"<br>");
document.write("Número em base binária: ");
for(var i = resto.length - 1;i>=0;i--)
{
	document.write(resto[i]);	
}