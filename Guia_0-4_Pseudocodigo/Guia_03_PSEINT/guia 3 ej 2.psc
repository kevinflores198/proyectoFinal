
Algoritmo sin_titulo
//Realizar una funci�n que valide si un n�mero es impar o no. Si es impar la funci�n debe
//devolver un verdadero, si no es impar debe devolver falso. Nota: la funci�n no debe tener
//mensajes que digan si es par o no, eso debe pasar en el Algoritmo.
	
	definir num, resultado Como Entero
	definir letra como logico
	
	Escribir "Ingrese un numero"
	Leer num	///num es el parametro
	
	resultado = divimod (num)
	si resultado = 0 Entonces
		letra = falso
		Escribir "par ", letra
	sino
		letra = verdadero
		Escribir "impar ", letra
	FinSi

FinAlgoritmo

Funcion np <- divimod ( num ) ///funcion es un subprograma que calcula todo lo anterior
	Definir np Como Entero
	np = num mod 2
Fin Funcion