//Continuando el ejercicio anterior, ahora se pedir� una frase o palabra y se validara si la
//primera letra de la frase es igual a la �ltima letra de la frase. Se deber� de imprimir un
//mensaje por pantalla que diga "CORRECTO", en caso contrario, se deber� imprimir
//"INCORRECTO".

Algoritmo ej8guia2
	Definir frase Como Caracter
	Escribir "Escriba una frase que comience y termine con la misma letra"
	Leer frase
	frase = Mayusculas(frase)
	Si SubCadena(frase,0,0) = SubCadena(frase,Longitud(frase)-1,Longitud(frase)-1) Entonces
		Escribir 'Correcto'
		SiNo
		Escribir 'Incorrecto'
	Fin Si
FinAlgoritmo
