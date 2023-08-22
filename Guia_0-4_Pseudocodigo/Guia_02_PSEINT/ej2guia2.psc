//Realiza un programa que sólo permita introducir los caracteres ?S? y ?N?. Si el usuario
//ingresa alguno de esos dos caracteres se deberá de imprimir un mensaje por pantalla que
//diga "CORRECTO", en caso contrario, se deberá imprimir "INCORRECTO".

Algoritmo ej2guia2
	Definir letra Como Caracter
		Escribir  "Escriba una S o N"
			Leer letra
letra = mayusculas (letra)
	
	Si letra = "S" o letra = "N" Entonces
		Escribir "CORRECTO"
		SiNo
		Escribir "INCORRECTO"
	Fin Si
FinAlgoritmo
