//Escriba un programa que permita al usuario ingresar el valor de dos variables numéricas de
//tipo entero. Posteriormente, el programa debe intercambiar los valores de ambas variables
//y mostrar el resultado final por pantalla.
//Por ejemplo, si el usuario ingresa los valores num1 = 9 y num2 = 3, la salida a del
//programa deberá mostrar: num1 = 3 y num2 = 9
//Ayuda: Para intercambiar los valores de dos variables se debe utilizar una variable auxiliar
Algoritmo ej5guia1
	Definir num1, num2, aux Como Entero
	Escribir "Ingrese dos numeros"
	Leer num1, num2
	aux = num1
	num1 = num2
	num2 = aux
	Escribir "Los valores intercambiados son " num1 " / " num2
FinAlgoritmo
