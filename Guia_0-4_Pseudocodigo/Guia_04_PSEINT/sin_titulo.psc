//Tomando en cuenta el ejercicio 6, mejore el mecanismo 
//de inserci�n del car�cter, facilitando
//un potencial reordenamiento del vector. Digamos que se
//pide ingresar el car�cter en la
//posici�n X y la misma est� ocupada, entonces de existir 
//un espacio en cualquier posici�n X-n
//o X+n, desplazar los caracteres hacia la izq o hacia 
//la derecha para poder ingresar el car�cter
//en cuesti�n en el lugar deseado. El procedimiento 
//de reordenamiento debe ubicar el espacio
//m�s cercano.
//	Por ejemplo, suponiendo la siguiente frase y 
//los sub�ndices del vector:
//H o l a m u n d o c r u e l !
//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
//Si se desea ingresar el car�cter "%" en la posici�n 8,
//entonces el resultado con
//desplazamiento ser�a:
//h o l a m u n % d o c r u e l !
//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
//Notar que el desplazamiento se hizo hacia la 
//izquierda porque el espacio de la posici�n 10
//estaba m�s cerca de la posici�n 8 que 
	//el espacio de la posici�n 4.
	SubProceso agregarcaracter(vector)
	Definir letra Como Caracter
	definir i, j, cont, izq, der Como Entero
	Escribir "Ingrese un caracter"
	leer letra
	Escribir "Ingrese la posucuion en la que desees colocarla"
	Leer j
	///------------------------------------------------------------
	cont = 0
	izq = 0
	der = 0
	///------------------------------------------------------------
	Si vector(j) = " " o vector(j) = "" Entonces
		vector(j) = letra
	SiNo
		para j=0 hasta 19 Hacer
			Si vector(i)= " " o vector(i)="" Entonces
				cont=cont+1
			FinSi
		FinPara
		si cont = 0 Entonces
			Escribir "Lo sentimos esta posicion estaba ocupada "
		SiNo
		finsi
		FinSi
	///------------------------------------------------------------
		//	para i=j hasta 0 con paso -1
		i=j
				mientras vector(i) <> " " o vector(i)<>"" hacer
					izq=izq+1
					i=i-1
				FinMientras
				
	//			FinSi
	//		FinPara
	//	FinSi
		
		Escribir izq
	///------------------------------------------------------------
		para i=j hasta 0 con paso -1
			Si vector(i) <> " " o vector(i)<>"" Entonces
				der=der+1
			FinSi
		FinPara
		
		Escribir der
		
		si izq<>der Entonces
			para i=izq hasta j
				vector(i)=vector(i+1)
			FinPara
		FinSi
		
		Escribir vector(j) = letra
	///-----------------------------------------------------------
		para i=der hasta j con paso -1
			vector(i) = vector(i-1)
		FinPara
	///------------------------------------------------------------
	vector(j)=letra
FinSubProceso

