//Realizar un programa que, dado un número entero, visualice en pantalla si es par o impar. 
//En caso de que el valor ingresado sea 0, se debe mostrar "el número no es par ni impar". 
//Nota: investigar la función mod de PSeInt


Algoritmo ej10guia2
	
	Definir num Como Entero
	Definir aux Como Real
	Escribir "Ingrese un numero entero"
	
	Leer num
	aux = num mod 2
	Si num = 0 Entonces
		Escribir "el número no es par ni impar"
	SiNo
	Segun aux Hacer
	0:
	Escribir "el numero es par"
	De Otro Modo:
	Escribir "El numero es impar"
	Fin Segun
	Fin Si
FinAlgoritmo
