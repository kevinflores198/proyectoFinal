Algoritmo sin_titulo
////Realizar un programa que rellene un vector
////de tama�o N, con valores ingresados por el
////usuario. A continuaci�n, se debe buscar un 
////elemento dentro del arreglo (el n�mero a buscar
////tambi�n debe ser ingresado por el usuario). 
////El programa debe indicar la posici�n donde se
////encuentra el valor. En caso que el n�mero 
////se encuentre repetido dentro del arreglo se deben
////imprimir todas las posiciones donde se encuentra 
////ese valor.	Finalmente, en caso que el n�mero a
////buscar no est� adentro del arreglo se debe mostrar
////un mensaje.
	
	Definir vector, tam, elem, i Como Entero
	Definir log Como Logico
	Escribir "Ingrese el tama�o del vector"
	Leer tam
	Dimension vector(tam)
	Para i <- 0 Hasta tam-1 Con Paso 1 Hacer
		Escribir "Ingrese 1 valor ", i
		Leer vector(i)
	FinPara
	
	Escribir "que valor desea buscar?"
	Leer elem
	log = falso
	
	Para i <- 0 Hasta tam-1 Con Paso 1 Hacer
		si vector i = elem
			Escribir "El numero se encuentra en la posicion ", i
			log = Verdadero
		FinSi
	FinPara
	si log = falso entonces
		Escribir "No se encuentra el valor"
	FinSi
FinAlgoritmo

///es mas efriciente usar un sino que usar dos si, tambien
/// podriamos haber elegido un contador
