//Crear un programa que solicite al usuario que ingrese el precio de un producto al inicio del
//año, y el precio del mismo producto al finalizar el año. El programa debe calcular cuál fue el
//porcentaje de aumento que tuvo ese producto en el año y mostrarlo por pantalla. 
Algoritmo ej5guia1
	Definir pre, pref, porc Como Real
	Escribir "Por favor ingrese el precio de su producto al iniciar el año"
	Leer pre
	Escribir "Gracias, ahora ingrece el precio del producto al finalizar el año"
	Leer pref
	porc = (pre*pref) / 100
	Si pref>=pre Entonces
		Escribir "El porcentaje que aumento en el año fue de un ",porc "%"
	SiNo
		Escribir "El porcentaje que disminuyo en el año fue un ", porc "%"
	FinSi
FinAlgoritmo
