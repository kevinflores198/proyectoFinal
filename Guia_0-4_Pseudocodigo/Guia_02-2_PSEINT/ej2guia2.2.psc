Algoritmo sin_titulo
// Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación solicite 
//números al usuario hasta que la suma de los números introducidos supere el límite inicial.
	
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
