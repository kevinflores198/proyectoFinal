//Un hombre desea saber si su sueldo es mayor al sueldo m�nimo, el programa le pedir� al
//usuario su sueldo actual y el sueldo m�nimo. Si el sueldo es mayor al m�nimo se debe
//mostrar un mensaje por pantalla indic�ndolo.

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
