//Solicitar al usuario que ingrese dos números enteros y determinar si ambos son pares o
//impares. Mostrar en pantalla un mensaje que indique "Ambos números son pares" siempre
//y cuando cumplan con la condición. En caso contrario se deberá imprimir el siguiente
//mensaje "Los números no son pares, o uno de ellos no es par".
Algoritmo ej3guia2_extras
	Definir num1,num2 como entero
	Escribir "por favor ingrese dos numeros"
	Leer num1, num2
	
	Si num1 mod 2 = 0 y num2 mod 2 = 0 Entonces ///usamos mod para saber por que numero se divide el numero ingresado y dejamos el resto que queremos
		Escribir "Ambos números son pares" 
		Sino
		Escribir "Los números no son pares, o uno de ellos no es par"
	FinSi
FinAlgoritmo
