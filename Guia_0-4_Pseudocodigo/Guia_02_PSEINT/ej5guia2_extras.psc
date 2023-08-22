//Solicitar al usuario que ingrese un valor entre 1 y 7. EL programa debe mostrar por pantalla
//un mensaje que indique a qué día de la semana corresponde. Considere que el número 1
//corresponde al día "Lunes", y así sucesivamente.

Algoritmo ej5guia2_extras
	Definir num Como Entero
	Escribir "Ingrese un numero entre 1 y 7"
	Leer num
	
	Si num=1 Entonces
		Escribir "El numero " num " pertenece al dia LUNES"
	Sino
		Si num=2 Entonces
			Escribir "El numero " num " pertenece al dia MARTES"
		SiNo
			Si num=3 Entonces
				Escribir "El numero " num " pertenece al dia MIERCOLES"
			SiNo
				Si num=4 Entonces
					Escribir "El numero " num " pertenece al dia JUEVES"
				SiNo
					Si num=5 Entonces
						Escribir "El numero " num " pertenece al dia VIERNES"
					SiNo
						Si num=6 Entonces
							Escribir "El numero " num " pertenece al dia SABADO"
						SiNo
							Si num=7 Entonces
								Escribir "El numero " num " pertenece al dia DOMINGO"
							SiNo
								Si num<>1 o num<>2 o num<>3 o num<>4 o num<>5 o num<>6 o num<>7 Entonces
									Escribir "El numero " num " no pertenece a algun dia de la semana"
								FinSi
							FinSi
						FinSi
					FinSi
				FinSi
			FinSi
		FinSi
	FinSi
	
	
FinAlgoritmo
