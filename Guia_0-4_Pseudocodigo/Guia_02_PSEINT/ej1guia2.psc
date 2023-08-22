//Un hombre desea saber si su sueldo es mayor al sueldo mínimo, el programa le pedirá al
//usuario su sueldo actual y el sueldo mínimo. Si el sueldo es mayor al mínimo se debe
//mostrar un mensaje por pantalla indicándolo.

Algoritmo ej1guia2
	
	Definir Sueldo_minimo, Sueldo_actual Como Real
	Escribir "Ingrese su sueldo actual"
	Leer Sueldo_actual
	Escribir "y el sueldo minimo"
	Leer Sueldo_minimo
	Si Sueldo_actual > Sueldo_minimo Entonces
		Escribir "Su sueldo es menor al sueldo minimo"
	Sino
		Escribir "Su sueldo es mayor al sueldo minimo"
	Fin Si
	
FinAlgoritmo
