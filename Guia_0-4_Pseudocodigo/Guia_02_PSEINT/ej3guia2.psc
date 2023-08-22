//Realizar un programa que pida un número y determine si ese número es par o impar.
//Mostrar en pantalla un mensaje que indique si el número es par o impar. (para que un
//número sea par, se debe dividir entre dos y su resto debe ser igual a 0). Nota: investigar
//la función mod de PseInt.

Algoritmo ej3guia2
	
	Definir num Como Entero
	Escribir "Ingrese numero"
	Leer num
	Si num mod 2 = 0 Entonces
		Escribir "El numero " num " es PAR"
		SiNo
		Escribir "El numero " num " es IMPAR"
	FinSi
	
	
FinAlgoritmo
