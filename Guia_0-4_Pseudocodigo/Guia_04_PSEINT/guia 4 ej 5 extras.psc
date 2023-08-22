//	5. Tomando en cuenta el ejercicio 6, mejore el mecanismo de inserci�n del car�cter, facilitando 
//	un potencial reordenamiento del vector. Digamos que se pide ingresar el car�cter en la 
//	posici�n X y la misma est� ocupada, entonces de existir un espacio en cualquier posici�n X-n 
//	o X+n, desplazar los caracteres hacia la izq o hacia la derecha para poder ingresar el car�cter 
//	en cuesti�n en el lugar deseado. El procedimiento de reordenamiento debe ubicar el espacio 
//	m�s cercano.
//	Por ejemplo, suponiendo la siguiente frase y los sub�ndices del vector:
//		H o l a m u n d o c r u e l !
//		0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
//	Si se desea ingresar el car�cter "%" en la posici�n 8, entonces el resultado con 
//	desplazamiento ser�a:
//		h o l a m u n % d o c r u e l !
//		0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
//	Notar que el desplazamiento se hizo hacia la izquierda porque el espacio de la posici�n 10 
//	estaba m�s cerca de la posici�n 8 que el espacio de la posici�n 4

Algoritmo Ejercicio6
	Definir frase, vector Como Caracter
	Definir i, aux Como Entero
	Dimension vector(20)
	
	Escribir "Ingrese una frase"
	Leer frase
	Para i=0 Hasta 19 Hacer
		vector(i)= Subcadena(frase, i, i)
	Fin Para
	
	aux=0
	Para i=0 Hasta 19 Hacer
		si vector(i)=" " o vector(i)="" Entonces
			aux=1
		FinSi
	Fin Para
	Si aux=0
		Escribir "Lo sentimos todas las posiciones est�n ocupadas"
	SiNo
		agregarcaracter(vector)
		Para i=0 Hasta 19 Hacer
			Escribir Sin Saltar vector(i)
		Fin Para
		Escribir ""
	FinSi
	
FinAlgoritmo

SubProceso agregarcaracter(vector)
	Definir letra Como Caracter
	Definir i, j, izq, der, aux Como Entero
	
	Escribir "Ingrese un car�cter"
	Leer letra
	Escribir "Ingrese la posici�n en la que desea colocarla"
	Leer j
	
	izq=0
	der=0
	aux=0
	Si vector(j)=" " o vector(j)="" Entonces
		vector(j)=letra	
	SiNo
		para i=j-1 hasta 0 con paso -1 hacer
			si aux=0 Entonces
				si vector(i)=" " Entonces
					aux=1
				SiNo
					izq=izq+1
				FinSi
			FinSi
		FinPara
		Imprimir "izq: " izq
		i=j
		aux=0
		para i=j+1 hasta 19 hacer
			si aux=0 Entonces
				si vector(i)=" " o vector(i)=" " Entonces
					aux=1
				SiNo
					der=der+1
				FinSi
			FinSi
		FinPara
		Imprimir "der: " der
		
		Si izq<=der Entonces
			Para i=j-(izq+1) Hasta j Hacer
				vector(i)=vector(i+1)
			FinPara
		SiNo
			para i=j+(der+1) hasta j Con Paso -1 Hacer
				vector(i)=vector(i-1)
			FinPara
		FinSi
		
		vector(j)=letra	
		
	FinSi
	
FinSubProceso
