
var a = prompt("Digite um valor A:"); //ENTRADA
var b = prompt("Digite um valor B:"); //ENTRADA
var aux;

aux = a; //ARMAZENA O VALOR DE "A" NA VAR "AUX"
a = b; // DA O VALOR DE "B" PARA "A"
b = aux; //ATRIBUI O VALOR DA "AUX" EM B

document.write("O novo valor de A agora é:"+a+"<br>"); //SAIDA
document.write("O novo valor de B agora é:"+b);		   //SAIDA