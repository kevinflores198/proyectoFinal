//Construir un programa que simule un men� de opciones para realizar las cuatro 
//operaciones aritm�ticas b�sicas (suma, resta, multiplicaci�n y divisi�n) con dos valores 
//num�ricos enteros. El usuario, adem�s, debe especificar la operaci�n con el primer 
//car�cter de la operaci�n que desea realizar: ?S' o ?s? para la suma, ?R? o ?r? para la resta, ?M? 
//o ?m? para la multiplicaci�n y ?D? o ?d? para la divisi�n.

Algoritmo ej9guia2
	
	Definir num1, num2 Como Entero
	Definir palabra Como Caracter
	Escribir "Ingrese su operacion"
	Leer num1, num2, palabra
	
	palabra = Mayusculas(palabra)
	
	Segun palabra Hacer
		"S":
			Escribir "La suma de estos numeros es: " , num1 + num2
		"R":
			Escribir "La resta de estos numeros es: ", num1 - num2
		"M":
			Escribir "La multiplicacion de estos numeros es: ", num1 * num2
		"D":
			Escribir "La division de estos numeros es: ", num1 / num2
		De Otro Modo:
			Escribir "La operacion ingresada no es valida"
	Fin Segun
	
FinAlgoritmo
