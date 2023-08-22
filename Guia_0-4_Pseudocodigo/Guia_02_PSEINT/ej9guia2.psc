//Construir un programa que simule un menú de opciones para realizar las cuatro 
//operaciones aritméticas básicas (suma, resta, multiplicación y división) con dos valores 
//numéricos enteros. El usuario, además, debe especificar la operación con el primer 
//carácter de la operación que desea realizar: ?S' o ?s? para la suma, ?R? o ?r? para la resta, ?M? 
//o ?m? para la multiplicación y ?D? o ?d? para la división.

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
