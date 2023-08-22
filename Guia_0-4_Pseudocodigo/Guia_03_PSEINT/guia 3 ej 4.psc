Algoritmo sin_titulo
	definir palabra, letra, resultado Como Caracter
	Escribir "Ingrese la frase y la letra a encontrar"
	Leer palabra, letra
	resultado = buscarletra(palabra,letra)
FinAlgoritmo

Funcion palabra2 = buscarletra(palabra,letra)
	Definir palabra2 Como Caracter
	Definir cont, i Como Entero
	cont = 0
	para i = 0 Hasta Longitud(palabra) Hacer ///cuando el paso es 1, uno lo puede obviar
		Si Subcadena(palabra, i, i) = letra Entonces
			cont = cont + 1
		FinSi
	FinPara
	Escribir "La letra " letra " esta repetida " cont " de veces"
FinFuncion

//Realizar un programa que pida al usuario una frase y una letra a buscar en esa frase. La
//función debe devolver la cantidad de veces que encontró la letra. Nota: recordar el uso de la
//función Subcadena.