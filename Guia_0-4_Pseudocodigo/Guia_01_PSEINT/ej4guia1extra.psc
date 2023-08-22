//A partir de una conocida cantidad de días que el usuario ingresa a través del teclado,
//escriba un programa para convertir los días en horas, en minutos y en segundos. Por
//ejemplo
//1 día = 24 horas = 1440 minutos = 86400 segundos

Algoritmo sin_titulo
	Definir dias, hor, min, seg Como Entero
	Escribir "Por favor ingrese la cantidad de dias"
	Leer dias
	hor = dias * 24
	min = dias * 1440
	seg = dias * 86400
	Escribir dias " dias = ", hor " horas = " min " minutos  = " seg " segundos "
FinAlgoritmo
