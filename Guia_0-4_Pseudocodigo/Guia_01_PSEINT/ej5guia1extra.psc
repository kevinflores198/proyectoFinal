//Crear un programa que solicite al usuario que ingrese el precio de un producto al inicio del
//a�o, y el precio del mismo producto al finalizar el a�o. El programa debe calcular cu�l fue el
//porcentaje de aumento que tuvo ese producto en el a�o y mostrarlo por pantalla. 
Algoritmo ej5guia1
	Definir pre, pref, porc Como Real
	Escribir "Por favor ingrese el precio de su producto al iniciar el a�o"
	Leer pre
	Escribir "Gracias, ahora ingrece el precio del producto al finalizar el a�o"
	Leer pref
	porc = (pre*pref) / 100
	Si pref>=pre Entonces
		Escribir "El porcentaje que aumento en el a�o fue de un ",porc "%"
	SiNo
		Escribir "El porcentaje que disminuyo en el a�o fue un ", porc "%"
	FinSi
FinAlgoritmo
