Algoritmo Guia_3_Ej_7
	Definir dias Como Entero
	Escribir "Ingrese cantidad de d�as"
	Leer dias
	media(dias)
FinAlgoritmo
Subproceso media(dia)
	Definir i Como Entero
	Definir max,min Como Real
	Para i=1 Hasta dia Hacer
		Escribir "Ingrese la temp maxima y la minima del d�a ",i
		Leer max,min
		Escribir "La media del d�a ",i," es de ",(max+min)/2
	FinPara
FinSubProceso
