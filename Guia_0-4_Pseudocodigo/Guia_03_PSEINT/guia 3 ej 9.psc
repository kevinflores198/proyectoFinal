Algoritmo ejercicio9
	definir frase, punto como caracter
	definir i como entero
	escribir "ingrese una frase"
	leer frase
	punto="."
	para i=0 hasta longitud(frase)-1 Hacer
		mientras punto <> subcadena(frase, longitud(frase)-1, longitud(frase)-1) hacer
			///si usamos longitud tenemos que usar el -1 para que cuente el ultimo caracter
			escribir "ingrese frase finalizando con punto"
			leer frase
		FinMientras
	FinPara
	
	transformacion(frase)
FinAlgoritmo

SubProceso transformacion (frase)
	definir i Como Entero
	definir frase1,letra Como Caracter
	frase1=""
	Para i <- 0 hasta longitud(frase)-1 Hacer
		Segun subcadena(frase,i,i) Hacer
			"a" O "A" : 
				letra= "@"
			"e" O "E": 
				letra= "#"
			"i" O "I" : 
				letra= "$"
			"o" O "O" : 
				letra= "%"
			"u" O "U" : 
				letra= "*"
			De Otro Modo:
				letra= subcadena(frase,i,i)
		FinSegun
		frase1=concatenar(frase1,letra)
	FinPara
	Escribir frase1
	
FinSubProceso
