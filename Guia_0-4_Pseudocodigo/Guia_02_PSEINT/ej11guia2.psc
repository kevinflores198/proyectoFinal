//Escriba un programa para obtener el grado de eficiencia de un operario de una f�brica de
//tornillos, de acuerdo a las siguientes dos condiciones que se le imponen para un per�odo
//de prueba:
//Producir menos de 200 tornillos defectuosos.
//Producir m�s de 10000 tornillos sin defectos.
//El grado de eficiencia se determina de la siguiente manera:
//Si no cumple ninguna de las condiciones, grado 5.
//Si s�lo cumple la primera condici�n, grado 6.
//Si s�lo cumple la segunda condici�n, grado 7.
//Si cumple las dos condiciones, grado 8
//Nota: para trabajar este ejercicio de manera prolija, ir probando cada inciso que pide el
//ejercicio. No hacer todos al mismo tiempo y despu�s probar.

Algoritmo ej11guia2
	Definir grado, tor, torde, condicion Como Entero
	Escribir "Ingrese cantidad de tornillos defectuosos"
	Leer torde
	Escribir "Ingrese canditad de tornillos sin defectos"
	Leer tor
	
	Si torde > 200 y 10000 > tor Entonces
		Escribir "La cantidad de tornillos defectuosos es de " torde " y la cantidad de tornillos sin defecto es de " tor "y el grado al que pertenecen es 5"
		SiNo
	Si torde < 200 y 10000 > tor Entonces
		Escribir "La cantidad de tornillos defectuosos es de " torde " y la cantidad de tornillos sin defecto es de " tor "y el grado al que pertenecen es 6"
		Sino
	Si torde > 200 y 10000 < tor Entonces
		Escribir "La cantidad de tornillos defectuosos es de " torde " y la cantidad de tornillos sin defecto es de " tor "y el grado al que pertenecen es 7"
		Sino
	Si torde < 200 y 10000 < tor Entonces
		Escribir "La cantidad de tornillos defectuosos es de " torde " y la cantidad de tornillos sin defecto es de " tor "y el grado al que pertenecen es 8"
	FinSi
	FinSi
	FinSi
	FinSi
FinAlgoritmo
