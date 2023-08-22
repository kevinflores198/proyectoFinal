//Leer tres números que denoten una fecha (día, mes, año) y comprobar que sea una fecha
//válida. Si la fecha no es válida escribir un mensaje de error por pantalla. Si la fecha es
//válida se debe imprimir la fecha cambiando el número que representa el mes por su
//nombre. Por ejemplo: si se introduce 1 2 2006, se deberá imprimir "1 de febrero de 2006". 

Algoritmo ej6guia2_extras
	Definir num1,num2,num3 Como Entero
	Escribir "Ingrese tres numeros para completar una fecha"
	Leer num1,num2,num3

	Si num2=1 Entonces
		Escribir "La fecha ingresada es: " num1 " de enero de " num3
	SiNo
		Si num2=2 Entonces
			Escribir "La fecha ingresada es: " num1 " de febrero de " num3
		SiNo
			Si num2=3 Entonces
				Escribir "La fecha ingresada es: " num1 " de marzo de " num3sino
			SiNo
				Si num2=4 Entonces
					Escribir "La fecha ingresada es: " num1 " de abril de " num3
				SiNo
					Si num2=5 Entonces
						Escribir "La fecha ingresada es: " num1 " de mayo de " num3
					SiNo
						Si num2=6 Entonces
							Escribir "La fecha ingresada es: " num1 " de junio de " num3
						SiNo
							Si num2=7 Entonces
								Escribir "La fecha ingresada es: " num1 " de julio de " num3
							SiNo
								Si num2=8 Entonces
									Escribir "La fecha ingresada es: " num1 " de agosto de " num3
								SiNo
									Si num2=9 Entonces
										Escribir "La fecha ingresada es: " num1 " de septiembre de " num3
									SiNo
										Si num2=10 Entonces
											Escribir "La fecha ingresada es: " num1 " de octubre de " num3
										SiNo
											Si num2=11 Entonces
												Escribir "La fecha ingresada es: " num1 " de noviembre de " num3
											SiNo
												Si num2=12 Entonces
													Escribir "La fecha ingresada es: " num1 " de diciembre de " num3
												SiNo
													Si num2>12 o num2<1 Entonces
														Escribir "La fecha ingresada no es valida"
												FinSi
											FinSi
										FinSi
									FinSi
								FinSi
							FinSi
						FinSi
					FinSi
				FinSi
			FinSi
		FinSi
	FinSi
FinSi
FinAlgoritmo
