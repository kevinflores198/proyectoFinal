Algoritmo sin_titulo
// Escriba un programa en el cual se ingrese un valor l�mite positivo, y a continuaci�n solicite 
//n�meros al usuario hasta que la suma de los n�meros introducidos supere el l�mite inicial.
	
	Definir num1, limite, suma como Real
	Escribir "ingrese un numero limite para realizar una suma"
	Leer limite
	
	suma = 0
	Repetir
		Escribir "Ingrese un valor"
		Leer num1
		suma = suma + num1
	Mientras Que suma < limite
	Escribir suma
	Escribir "Haz superado el limite"
	
FinAlgoritmo
