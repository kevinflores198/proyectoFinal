//A partir de una conocida cantidad de d�as que el usuario ingresa a trav�s del teclado,
//escriba un programa para convertir los d�as en horas, en minutos y en segundos. Por
//ejemplo
//1 d�a = 24 horas = 1440 minutos = 86400 segundos

Algoritmo sin_titulo
	Definir dias, hor, min, seg Como Entero
	Escribir "Por favor ingrese la cantidad de dias"
	Leer dias
	hor = dias * 24
	min = dias * 1440
	seg = dias * 86400
	Escribir dias " dias = ", hor " horas = " min " minutos  = " seg " segundos "
FinAlgoritmo
