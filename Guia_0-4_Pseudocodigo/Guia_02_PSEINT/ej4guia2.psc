//Realizar un programa que pida introducir solo frases o palabras de 6 caracteres. Si el
//usuario ingresa una frase o palabra de 6 caracteres se deber� de imprimir un mensaje por
//pantalla que diga "CORRECTO", en caso contrario, se deber� imprimir "INCORRECTO".
//Nota: investigar la funci�n Longitud() de PseInt.

Algoritmo ej4guia2
	
	Definir palabra Como Caracter
	Escribir "Por favor ingrese una palabra de 6 caracteres"
	Leer palabra
	
	Si Longitud(palabra) = 6 Entonces
		Escribir "CORRECTO"
		SiNo
		Escribir "INCORRECTO"
	FinSi
FinAlgoritmo
