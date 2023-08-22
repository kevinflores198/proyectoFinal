//Escriba un programa que pida una frase o palabra y valide si la primera letra de esa frase
//es una ?A?. Si la primera letra es una ?A?, se deberá de imprimir un mensaje por pantalla
//que diga "CORRECTO", en caso contrario, se deberá imprimir "INCORRECTO". Nota:
//investigar la función Subcadena de PseInt.


Algoritmo ej7guia2
	Definir frase Como Caracter
	Escribir "Escriba una frase o palabra que comience con A"
	Leer frase
	frase = Mayusculas(frase)
	Si SubCadena(frase,0,0) = "A" Entonces
		Escribir "CORRECTO"
	SiNo
		Escribir "ICORRECTO"
	Fin Si

FinAlgoritmo