var n = parseInt(prompt("Quantidade de termos?"));
var termo1 = 0;
var termo2 = 1;
var termo3;
document.write(termo1+", "+termo2);
for(i = 3;i<= n;i++)
{
	termo3 = termo1 + termo2;
	document.write(", "+termo3);
	termo1 = termo2;
	termo2 = termo3;
}